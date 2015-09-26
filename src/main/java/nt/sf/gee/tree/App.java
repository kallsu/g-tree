/**
 * -------------------------------------------------------------------------------------------------
 * 
 * Copyright 2015 - Giorgio Desideri
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 * 
 * See the License for the specific language governing permissions and limitations under the
 * License.
 * 
 */
package nt.sf.gee.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The Class App.
 */
public class App {

  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {

    System.out.println("Ladies and Gentlemen start your JVM");

    TreeNode a = new TreeNode("a");
    TreeNode b = new TreeNode("b");
    TreeNode c = new TreeNode("c");
    TreeNode d = new TreeNode("d");
    TreeNode e = new TreeNode("e");
    TreeNode f = new TreeNode("f");
    TreeNode g = new TreeNode("g");

    // a -> b, c
    // b -> d
    // c -> e, f, g

    c.addChild(e);
    c.addChild(f);
    c.addChild(g);

    b.addChild(d);

    a.addChild(b);
    a.addChild(c);

    System.out.println("Print by level.");
    printByLevel(a);

    System.out.println("\nPrint by deep.");
    printByDeep(a);

    System.out.println("\nThat's all Folks!");
  }

  /**
   * Prints the by deep.
   *
   * @param node the node
   */
  private static void printByDeep(TreeNode node) {

    if (node == null) {
      return;
    }

    if (node.getData() != null) {
      System.out.print(node.getData() + ", ");
    }

    if (node.getChildren().isEmpty()) {
      return;

    }
    else {
      for (TreeNode child : node.getChildren()) {
        printByDeep(child);
      }
    }
  }

  /**
   * Prints the by level.
   *
   * @param n the n
   */
  public static void printByLevel(TreeNode node) {

    Queue<TreeNode> queue = new LinkedList<>();

    if (node != null) {
      queue.add(node);
    }

    while (!queue.isEmpty()) {
      TreeNode next = queue.remove();

      System.out.print(next.getData() + ", ");

      if (!next.getChildren().isEmpty()) {
        queue.addAll(next.getChildren());
      }
    }
  }
}
