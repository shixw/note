package cc.shixw.algorithms;

/**
 * description: 红黑树
 * date: 2019-12-22 15:33
 * author: shixianwei
 */
public class RBTree<T extends Comparable<T>> {
    //数节点颜色
    private static final boolean RED   = false;
    private static final boolean BLACK = true;


    private RBNode root;

    /**
     * 节点左旋操作
     * @param x 旋转的节点
     */
    private void leftRotate(RBNode<T> x){
        //1. 将y的左子节点赋给x的右子节点，并将x赋给y左子节点的父节点(y左子节点非空时)
        RBNode<T> y = x.right;
        x.right = y.left;
        if(y.left != null){
            y.left.parent = x;
        }

        //2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
        y.parent = x.parent;
        if(x.parent == null){
            this.root = y;//如果x的父节点为空(即x为根节点)，则将y设为根节点
        }else{
            if(x == x.parent.left){//如果x是左子节点
                x.parent.left = y;//则也将y设为左子节点
            }else{
                x.parent.right = y;//否则将y设为右子节点
            }
        }

        //3. 将y的左子节点设为x，将x的父节点设为y
        y.left = x;
        x.parent = y;
    }

    /**
     * 节点右旋操作
     * @param y
     */
    private void rightRotate(RBNode<T> y){
        //1. 将y的左子节点赋给x的右子节点，并将x赋给y左子节点的父节点(y左子节点非空时)
        RBNode<T> x = y.left;
        y.left = x.right;
        if(x.right != null){
            x.right.parent = y;
        }

        //2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
        x.parent = y.parent;
        if(y.parent == null){
            this.root = x;//如果y的父节点为空(即y为根节点)，则旋转后将x设为根节点
        }else{
            if(y == y.parent.left){//如果y是左子节点
                y.parent.left = x;//则将x也设置为左子节点
            }else{
                y.parent.right = x;//否则将x设置为右子节点
            }
        }

        //3. 将x的左子节点设为y，将y的父节点设为y
        x.right = y;
        y.parent = x;

    }

    /**
     * 红黑树节点
     * @param <T>
     */
    class RBNode<T>{
        /**
         * 颜色
         */
        boolean color;
        /**
         * 值
         */
        T key;
        /**
         * 左节点
         */
        RBNode<T> left;
        /**
         * 右节点
         */
        RBNode<T> right;
        /**
         * 父节点
         */
        RBNode<T> parent;

        public RBNode(boolean color, T key, RBNode<T> left, RBNode<T> right, RBNode<T> parent) {
            this.color = color;
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        /**
         * 获取节点的关键值
         * @return
         */
        public T getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "RBNode{" +
                    "color=" + (this.color == RED ? "R":"B") +
                    ", key=" + key +
                    '}';
        }
    }
}
