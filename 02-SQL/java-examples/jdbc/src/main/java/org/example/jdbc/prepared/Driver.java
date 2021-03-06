package org.example.jdbc.prepared;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

public class Driver {

    public static void main(String[] args) {
        PreparedExample p = new PreparedExample();
        p.create("fhgkudhs");
        System.out.println(p.findById(2));
    }
}
