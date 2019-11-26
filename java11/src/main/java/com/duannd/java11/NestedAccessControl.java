package com.duannd.java11;

public class NestedAccessControl {

    public void myPublic() {
        System.out.println("NestedAccessControl :: Public");
    }

    private void myPrivate() {
        System.out.println("NestedAccessControl :: Private");
    }

    class Nested {
        public void nestedPublic() {
            myPrivate();
        }
    }

}
