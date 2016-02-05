package com.linyou.students.model;

/**
 * Created by shuli on 16/2/4.
 */
public class InnerClass {

    private String str;

    private class DefaultInnerClass{

        private String str;

        private String getString(){
            return "vvvv";
        }
    }

    protected class DefaultProectedClass{

        private String str;

    }

    public class DefaultPublicClass{

        private String str;

        private String getString(){
            return "";
        }
    }

    class DefaultClass{

        private String str;

        private String getString(){
            return "sdfsdf";
        }
    }



}
