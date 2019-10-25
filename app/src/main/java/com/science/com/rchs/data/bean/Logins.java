package com.science.com.rchs.data.bean;

public class Logins {
        private int code;

        private String message;

        private Data data;

        public void setCode(int code){
            this.code = code;
        }
        public int getCode(){
            return this.code;
        }
        public void setMessage(String message){
            this.message = message;
        }
        public String getMessage(){
            return this.message;
        }
        public void setData(Data data){
            this.data = data;
        }
        public Data getData(){
            return this.data;
        }
        public class Data {
            private String access_token;

            private String token_type;

            private String expires_in;

            public void setAccess_token(String access_token){
                this.access_token = access_token;
            }
            public String getAccess_token(){
                return this.access_token;
            }
            public void setToken_type(String token_type){
                this.token_type = token_type;
            }
            public String getToken_type(){
                return this.token_type;
            }
            public void setExpires_in(String expires_in){
                this.expires_in = expires_in;
            }
            public String getExpires_in(){
                return this.expires_in;
            }

        }

}
