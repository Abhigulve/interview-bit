package threding;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Thread.sleep;

/**
 * @author Abhijeet Gulve
 */
public class BFSThread {
    public static void main(String[] args) {


        final BFS bfs = new BFS(89);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread t = Thread.currentThread();
//                System.out.println(t);
                System.out.println(bfs.isElementAvailable());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread t = Thread.currentThread();
//                System.out.println(t);
                System.out.println(bfs.isElementAvailable());
            }
        });
        t1.start();
        t2.start();
    }
}

class BFS {
    Queue<TreeNode> queue = new ArrayDeque<>();
    private Integer ele;
    private AtomicBoolean atomic = new AtomicBoolean(false);
    private TreeNode t = mockTree();

    public BFS(Integer ele) {
        this.ele = ele;
        queue.add(t);
    }

    public static TreeNode mockTree() {
        TreeNode treeNode = new TreeNode();
        treeNode.data = 10;
        TreeNode t1 = new TreeNode();
        t1.data = 20;
        TreeNode t2 = new TreeNode();
        t2.data = 30;
        treeNode.right = t1;
        treeNode.left = t2;
        TreeNode t3 = new TreeNode();
        t3.data = 34;
        TreeNode t4 = new TreeNode();
        t3.data = 45;
        t1.left = t3;
        t1.right = t4;
        TreeNode t5 = new TreeNode();
        t5.data = 65;
        TreeNode t6 = new TreeNode();
        t6.data = 89;
        t2.right = t5;
        t2.left = t6;
        return treeNode;
    }

    public boolean isElementAvailable() {

        synchronized (this) {
            while (!queue.isEmpty()) {

                TreeNode treeNode = queue.poll();
                System.out.println("thread is "+Thread.currentThread()+"   "+treeNode.data);
                if(atomic.get()){
                    System.out.println("already found variable");
                    System.out.println("killing self "+ Thread.currentThread());
//                    Thread.currentThread().interrupt();
                    return true;
                }
                if (treeNode.data == ele ) {
                    atomic.set(true);
                    System.out.println("Element Found " + ele);
                    System.out.println("killing self "+ Thread.currentThread());
//                    Thread.currentThread().interrupt();
                    return true;
                }
                if (treeNode.left != null)
                    queue.add(treeNode.left);
                if (treeNode.right != null)
                    queue.add(treeNode.right);
                try {
                    notifyAll();
                    wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

}
