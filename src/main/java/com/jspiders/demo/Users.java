package com.jspiders.demo;


    //EntityClass
    public class Users {
        private Long userid;
        private String name;
        private String mobile;
        private String password;

        public Long getUserid() {
            return userid;
        }

        public void setUserid(Long userid) {
            this.userid = userid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "Users{" +
                    "userid=" + userid +
                    ", name='" + name + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

