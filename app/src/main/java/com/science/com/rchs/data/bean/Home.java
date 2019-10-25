package com.science.com.rchs.data.bean;

import com.google.gson.annotations.SerializedName;

public class Home {

    /**
     * code : 0
     * message : 请求成功
     * data : {"membersTotal":3,"membersTotalToday":0,"couponsTotal":2,"couponsTotalToday":0,"cardList":{"1":{"day":"2019-08-14","count":2},"2":{"day":"2019-08-13","count":0},"3":{"day":"2019-08-12","count":0},"4":{"day":"2019-08-11","count":0},"5":{"day":"2019-08-10","count":1},"6":{"day":"2019-08-09","count":0},"7":{"day":"2019-08-08","count":0}},"couponList":{"1":{"day":"2019-08-14","count":2},"2":{"day":"2019-08-13","count":0},"3":{"day":"2019-08-12","count":0},"4":{"day":"2019-08-11","count":0},"5":{"day":"2019-08-10","count":0},"6":{"day":"2019-08-09","count":0},"7":{"day":"2019-08-08","count":0}}}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * membersTotal : 3
         * membersTotalToday : 0
         * couponsTotal : 2
         * couponsTotalToday : 0
         * cardList : {"1":{"day":"2019-08-14","count":2},"2":{"day":"2019-08-13","count":0},"3":{"day":"2019-08-12","count":0},"4":{"day":"2019-08-11","count":0},"5":{"day":"2019-08-10","count":1},"6":{"day":"2019-08-09","count":0},"7":{"day":"2019-08-08","count":0}}
         * couponList : {"1":{"day":"2019-08-14","count":2},"2":{"day":"2019-08-13","count":0},"3":{"day":"2019-08-12","count":0},"4":{"day":"2019-08-11","count":0},"5":{"day":"2019-08-10","count":0},"6":{"day":"2019-08-09","count":0},"7":{"day":"2019-08-08","count":0}}
         */

        private int membersTotal;
        private int membersTotalToday;
        private int couponsTotal;
        private int couponsTotalToday;
        private CardListBean cardList;
        private CouponListBean couponList;

        public int getMembersTotal() {
            return membersTotal;
        }

        public void setMembersTotal(int membersTotal) {
            this.membersTotal = membersTotal;
        }

        public int getMembersTotalToday() {
            return membersTotalToday;
        }

        public void setMembersTotalToday(int membersTotalToday) {
            this.membersTotalToday = membersTotalToday;
        }

        public int getCouponsTotal() {
            return couponsTotal;
        }

        public void setCouponsTotal(int couponsTotal) {
            this.couponsTotal = couponsTotal;
        }

        public int getCouponsTotalToday() {
            return couponsTotalToday;
        }

        public void setCouponsTotalToday(int couponsTotalToday) {
            this.couponsTotalToday = couponsTotalToday;
        }

        public CardListBean getCardList() {
            return cardList;
        }

        public void setCardList(CardListBean cardList) {
            this.cardList = cardList;
        }

        public CouponListBean getCouponList() {
            return couponList;
        }

        public void setCouponList(CouponListBean couponList) {
            this.couponList = couponList;
        }

        public static class CardListBean {
            /**
             * 1 : {"day":"2019-08-14","count":2}
             * 2 : {"day":"2019-08-13","count":0}
             * 3 : {"day":"2019-08-12","count":0}
             * 4 : {"day":"2019-08-11","count":0}
             * 5 : {"day":"2019-08-10","count":1}
             * 6 : {"day":"2019-08-09","count":0}
             * 7 : {"day":"2019-08-08","count":0}
             */

            @SerializedName("1")
            private _$1Bean _$1;
            @SerializedName("2")
            private _$2Bean _$2;
            @SerializedName("3")
            private _$3Bean _$3;
            @SerializedName("4")
            private _$4Bean _$4;
            @SerializedName("5")
            private _$5Bean _$5;
            @SerializedName("6")
            private _$6Bean _$6;
            @SerializedName("7")
            private _$7Bean _$7;

            public _$1Bean get_$1() {
                return _$1;
            }

            public void set_$1(_$1Bean _$1) {
                this._$1 = _$1;
            }

            public _$2Bean get_$2() {
                return _$2;
            }

            public void set_$2(_$2Bean _$2) {
                this._$2 = _$2;
            }

            public _$3Bean get_$3() {
                return _$3;
            }

            public void set_$3(_$3Bean _$3) {
                this._$3 = _$3;
            }

            public _$4Bean get_$4() {
                return _$4;
            }

            public void set_$4(_$4Bean _$4) {
                this._$4 = _$4;
            }

            public _$5Bean get_$5() {
                return _$5;
            }

            public void set_$5(_$5Bean _$5) {
                this._$5 = _$5;
            }

            public _$6Bean get_$6() {
                return _$6;
            }

            public void set_$6(_$6Bean _$6) {
                this._$6 = _$6;
            }

            public _$7Bean get_$7() {
                return _$7;
            }

            public void set_$7(_$7Bean _$7) {
                this._$7 = _$7;
            }

            public static class _$1Bean {
                /**
                 * day : 2019-08-14
                 * count : 2
                 */

                private String day;
                private int count;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }
            }

            public static class _$2Bean {
                /**
                 * day : 2019-08-13
                 * count : 0
                 */

                private String day;
                private int count;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }
            }

            public static class _$3Bean {
                /**
                 * day : 2019-08-12
                 * count : 0
                 */

                private String day;
                private int count;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }
            }

            public static class _$4Bean {
                /**
                 * day : 2019-08-11
                 * count : 0
                 */

                private String day;
                private int count;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }
            }

            public static class _$5Bean {
                /**
                 * day : 2019-08-10
                 * count : 1
                 */

                private String day;
                private int count;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }
            }

            public static class _$6Bean {
                /**
                 * day : 2019-08-09
                 * count : 0
                 */

                private String day;
                private int count;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }
            }

            public static class _$7Bean {
                /**
                 * day : 2019-08-08
                 * count : 0
                 */

                private String day;
                private int count;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }
            }
        }

        public static class CouponListBean {
            /**
             * 1 : {"day":"2019-08-14","count":2}
             * 2 : {"day":"2019-08-13","count":0}
             * 3 : {"day":"2019-08-12","count":0}
             * 4 : {"day":"2019-08-11","count":0}
             * 5 : {"day":"2019-08-10","count":0}
             * 6 : {"day":"2019-08-09","count":0}
             * 7 : {"day":"2019-08-08","count":0}
             */

            @SerializedName("1")
            private _$1BeanX _$1;
            @SerializedName("2")
            private _$2BeanX _$2;
            @SerializedName("3")
            private _$3BeanX _$3;
            @SerializedName("4")
            private _$4BeanX _$4;
            @SerializedName("5")
            private _$5BeanX _$5;
            @SerializedName("6")
            private _$6BeanX _$6;
            @SerializedName("7")
            private _$7BeanX _$7;

            public _$1BeanX get_$1() {
                return _$1;
            }

            public void set_$1(_$1BeanX _$1) {
                this._$1 = _$1;
            }

            public _$2BeanX get_$2() {
                return _$2;
            }

            public void set_$2(_$2BeanX _$2) {
                this._$2 = _$2;
            }

            public _$3BeanX get_$3() {
                return _$3;
            }

            public void set_$3(_$3BeanX _$3) {
                this._$3 = _$3;
            }

            public _$4BeanX get_$4() {
                return _$4;
            }

            public void set_$4(_$4BeanX _$4) {
                this._$4 = _$4;
            }

            public _$5BeanX get_$5() {
                return _$5;
            }

            public void set_$5(_$5BeanX _$5) {
                this._$5 = _$5;
            }

            public _$6BeanX get_$6() {
                return _$6;
            }

            public void set_$6(_$6BeanX _$6) {
                this._$6 = _$6;
            }

            public _$7BeanX get_$7() {
                return _$7;
            }

            public void set_$7(_$7BeanX _$7) {
                this._$7 = _$7;
            }

            public static class _$1BeanX {
                /**
                 * day : 2019-08-14
                 * count : 2
                 */

                private String day;
                private int count;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }
            }

            public static class _$2BeanX {
                /**
                 * day : 2019-08-13
                 * count : 0
                 */

                private String day;
                private int count;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }
            }

            public static class _$3BeanX {
                /**
                 * day : 2019-08-12
                 * count : 0
                 */

                private String day;
                private int count;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }
            }

            public static class _$4BeanX {
                /**
                 * day : 2019-08-11
                 * count : 0
                 */

                private String day;
                private int count;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }
            }

            public static class _$5BeanX {
                /**
                 * day : 2019-08-10
                 * count : 0
                 */

                private String day;
                private int count;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }
            }

            public static class _$6BeanX {
                /**
                 * day : 2019-08-09
                 * count : 0
                 */

                private String day;
                private int count;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }
            }

            public static class _$7BeanX {
                /**
                 * day : 2019-08-08
                 * count : 0
                 */

                private String day;
                private int count;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }
            }
        }
    }
}
