package zmk.red_black_tree;

/**
 * Created by Administrator on 2018/8/3/003.
 */

import static zmk.red_black_tree.MyEntry.BLACK;
import static zmk.red_black_tree.MyEntry.RED;

/**
 * TreeMap底层是红黑树，简单实现TreeMap底层原理
 */
public class MyTreeMap<K, V> {

    private MyEntry<K, V> root;

    private int size = 0;

    public V put(K key, V value) {
        MyEntry<K, V> entry = new MyEntry(key, value, null);
        if (this.root == null) {
            root = entry;
            root.color = BLACK;
            size++;
            return value;
        }
        if (key == null)
            throw new NullPointerException();
        MyEntry<K, V> parent = root;
        Comparable<? super K> k = (Comparable<? super K>) key;
        do {
            int cmp = k.compareTo(parent.key);
            if (cmp < 0) {
                MyEntry<K, V> left = parent.left;
                if (left == null) {
                    parent.left = entry;
                    break;
                }
                parent = left;
            } else if (cmp > 0) {
                MyEntry<K, V> right = parent.right;
                if (right == null) {
                    parent.right = entry;
                    break;
                }
                parent = right;
            } else
                return entry.setValue(value);
        } while (parent != null);
        entry.parent = parent;
        fixedRedBlackTree(entry);
        size++;
        return value;
    }

    /**
     * 对插入后的节点进行修正
     *
     * @param entry
     */
    private void fixedRedBlackTree(MyEntry<K, V> entry) {

        while (entry != null && entry != root && entry.parent.color == RED) {
            //true表示父节点是祖父节点的左子树
            boolean fatherLocation = parentOf(entry) == leftTree(parentOf(parentOf(entry)));
            //true表示当前节点是父节点的左子树
            boolean location = entry == leftTree(parentOf(entry));
            //父节点是祖父节点的左子树
            if (fatherLocation) {
                MyEntry uncle = rightTree(parentOf(parentOf(entry)));
                //叔叔节点是红色
                if (uncle != null && uncle.color == RED) {
                    /**
                     * 父节点设置为黑色
                     叔叔节点设置为黑色
                     祖父节点设置为红色
                     当前节点设置为祖父节点
                     */
                    setColor(entry.parent,BLACK);
                    setColor(rightTree(parentOf(parentOf(entry))),BLACK);
                    setColor(parentOf(parentOf(entry)),RED);
                    entry = parentOf(parentOf(entry));
                }
                //叔叔节点是黑色
                else {
                    //当前节点是右子树
                    if (!location) {
                        //当前节点设置为父节点
                        //对当前节点进行左旋转
                        entry = parentOf(entry);
                        leftRotation(entry);
                    }
                    //设置父节点的颜色为黑色
                    //设置祖父节点的颜色为红色
                    //对祖父节点进行右旋转
                    setColor(parentOf(entry), BLACK);
                    setColor(parentOf(parentOf(entry)), RED);
                    rightRotation(parentOf(parentOf(entry)));
                }
                //父节点是爷爷节点的右子树
            } else {
                MyEntry uncle = leftTree(parentOf(parentOf(entry)));
                //叔叔节点是红色
                if (uncle != null && uncle.color == RED) {
                    //设置父节点为黑色
                    //设置叔叔节点为黑色
                    //设置祖父节点为红色
                    //祖父节点当成当前节点
                    setColor(parentOf(entry),BLACK);
                    setColor(leftTree(parentOf(parentOf(entry))),BLACK);
                    setColor(parentOf(parentOf(entry)),RED);
                    entry = parentOf(parentOf(entry));
                }
                //叔叔节点是黑色
                else {
                    //当前节点是左子树
                    if (location) {
                        //设置当前节点为父节点
                        //右旋转当前节点
                        entry = entry.parent;
                        rightRotation(entry);
                    }
                    //当前节点父节点设置为黑色
                    //设置当前节点祖父节点为红色
                    //左旋转当前节点祖父节点
                    setColor(parentOf(entry),BLACK);
                    setColor(parentOf(parentOf(entry)),RED);
                    leftRotation(entry.parent.parent);
                    //叔叔节点是红色
                }
            }
        }
        root.color = BLACK;
    }

    /**
     * 获取父节点
     *
     * @param entry
     * @return
     */
    private MyEntry parentOf(MyEntry<K, V> entry) {
        return entry == null ? null : entry.parent;
    }

    /**
     * 获得当前节点的左子树
     *
     * @param parent
     * @return
     */

    private MyEntry<K, V> leftTree(MyEntry<K, V> parent) {
        return parent == null ? null : parent.left;
    }

    /**
     * 获得当前节点的右子树
     *
     * @param parent
     * @return
     */
    private MyEntry<K, V> rightTree(MyEntry<K, V> parent) {
        return parent == null ? null : parent.right;
    }

    /**
     * 设置颜色
     *
     * @param color
     */
    private MyEntry setColor(MyEntry entry, boolean color) {
        if (entry != null) {
            entry.color = color;
            return entry;
        }
        return null;

    }

    /**
     * 右旋转
     * 顺时针旋转红黑树的两个节点，使得父节点被自己的左孩子取代，而自己成为自己的右孩子
     *
     * @param p
     */
    private void rightRotation(MyEntry<K, V> p) {
        if (p != null) {
            MyEntry<K, V> l = p.left;
            //父节点的左子树变成左子树的右子树
            p.left = l.right;
            if (l.right != null)
                l.right.parent = p;
            l.parent = p.parent;
            if (p.parent == null)
                root = l;
            else if (p.parent.right == p)
                p.parent.right = l;
            else
                p.parent.left = l;
            l.right = p;
            p.parent = l;
        }
    }

    /**
     * 左旋转
     * 逆时针旋转红黑树的两个节点，使得父节点被自己的右孩子取代，而自己成为自己右孩子的左孩子
     *
     * @param p
     */
    private void leftRotation(MyEntry<K, V> p) {
        if (p != null) {
            MyEntry<K, V> r = p.right;
            //父节点的右子树变成有右子树的左子树
            p.right = r.left;
            if (r.left != null)
                r.left.parent = p;
            //右子树变成父字树
            r.parent = p.parent;
            if (p.parent == null)
                root = r;
            else if (p.parent.left == p)
                p.parent.left = r;
            else
                p.parent.right = r;
            r.left = p;
            p.parent = r;
        }
    }

    /**
     * 检查是否已经调整完毕
     *
     * @param entry
     * @return
     */
    private boolean ifFinished(MyEntry<K, V> entry) {
        MyEntry parent = entry.parent;
        MyEntry left = entry.left;
        MyEntry right = entry.right;
        if (checkIfColorEquine(entry, parent)) {
            return false;
        } else if (checkIfColorEquine(entry, left)) {
            return false;
        } else if (checkIfColorEquine(entry, right)) {
            return false;
        }
        return true;
    }

    /**
     * 检查颜色是否都是红色
     *
     * @param entry
     * @param parent
     */
    private boolean checkIfColorEquine(MyEntry<K, V> entry, MyEntry parent) {
        if (parent == null) {
            return false;
        }
        if (!entry.color && !parent.color) {
            return true;
        }
        return false;
    }

    public MyEntry<K, V> getRoot() {
        return this.root;
    }

    public V get(K key) {
        MyEntry<K, V> entry = root;
        while (entry != null) {
            Comparable<? super K> k = (Comparable<? super K>) key;
            int cmp = k.compareTo(entry.key);
            if (cmp == 0) {
                return entry.value;
            }
            if (cmp < 0) {
                entry = entry.left;
            } else {
                entry = entry.right;
            }
        }
        return null;
    }

    public int size() {
        return this.size;
    }

}
