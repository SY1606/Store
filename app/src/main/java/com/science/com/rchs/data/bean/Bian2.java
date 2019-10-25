package com.science.com.rchs.data.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Bian2 {

    /**
     * code : 0
     * message : 请求成功
     * data : {"card_type":"DISCOUNT","discount":{"base_info":{"id":"pD9sF1Y6-ndvU8ZHC90bHXcUU4y8","logo_url":"http://mmbiz.qpic.cn/mmbiz_jpg/MV8dBUmdfs58nc3IXyfLib2LS1rjFpawbibSDm1L0c7L3RHd5J8yqQOjlFDOfG2OoueHoDWcDNQnHviasSicXGiclgQ/0","code_type":"CODE_TYPE_QRCODE","brand_name":"路云家居用品","title":"5折券","date_info":{"type":"DATE_TYPE_FIX_TIME_RANGE","begin_timestamp":1569254400,"end_timestamp":1569772800},"color":"#2c9f67","notice":"明明","description":"狗狗公共","location_id_list":[],"use_limit":1,"get_limit":1,"can_share":true,"can_give_friend":false,"status":"CARD_STATUS_VERIFY_OK","sku":{"quantity":19,"total_quantity":20},"create_time":1569325215,"update_time":1569325225,"area_code_list":[]},"discount":50,"advanced_info":{"time_limit":[{"type":"MONDAY"},{"type":"TUESDAY"},{"type":"WEDNESDAY"},{"type":"THURSDAY"},{"type":"FRIDAY"},{"type":"SATURDAY"},{"type":"SUNDAY"}],"text_image_list":[],"business_service":[],"consume_share_card_list":[],"abstract":{"icon_url_list":["http://mmbiz.qpic.cn/mmbiz_jpg/MV8dBUmdfs7e3zYM3TToekqichyyA0Y5LOZibWYjGQ465hmd9wWHfA6cylWAVzlA5bxZSvKI3y8Lm1EJOyzMJm8Q/0"]},"share_friends":false}}}
     */

    private int code;
    private String message;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * card_type : DISCOUNT
         * discount : {"base_info":{"id":"pD9sF1Y6-ndvU8ZHC90bHXcUU4y8","logo_url":"http://mmbiz.qpic.cn/mmbiz_jpg/MV8dBUmdfs58nc3IXyfLib2LS1rjFpawbibSDm1L0c7L3RHd5J8yqQOjlFDOfG2OoueHoDWcDNQnHviasSicXGiclgQ/0","code_type":"CODE_TYPE_QRCODE","brand_name":"路云家居用品","title":"5折券","date_info":{"type":"DATE_TYPE_FIX_TIME_RANGE","begin_timestamp":1569254400,"end_timestamp":1569772800},"color":"#2c9f67","notice":"明明","description":"狗狗公共","location_id_list":[],"use_limit":1,"get_limit":1,"can_share":true,"can_give_friend":false,"status":"CARD_STATUS_VERIFY_OK","sku":{"quantity":19,"total_quantity":20},"create_time":1569325215,"update_time":1569325225,"area_code_list":[]},"discount":50,"advanced_info":{"time_limit":[{"type":"MONDAY"},{"type":"TUESDAY"},{"type":"WEDNESDAY"},{"type":"THURSDAY"},{"type":"FRIDAY"},{"type":"SATURDAY"},{"type":"SUNDAY"}],"text_image_list":[],"business_service":[],"consume_share_card_list":[],"abstract":{"icon_url_list":["http://mmbiz.qpic.cn/mmbiz_jpg/MV8dBUmdfs7e3zYM3TToekqichyyA0Y5LOZibWYjGQ465hmd9wWHfA6cylWAVzlA5bxZSvKI3y8Lm1EJOyzMJm8Q/0"]},"share_friends":false}}
         */

        private String card_type;
        private Object discount;

        public String getCard_type() {
            return card_type;
        }

        public void setCard_type(String card_type) {
            this.card_type = card_type;
        }

        public Object getDiscount() {
            return discount;
        }

        public void setDiscount(Object discount) {
            this.discount = discount;
        }

        public static class DiscountBean {
            /**
             * base_info : {"id":"pD9sF1Y6-ndvU8ZHC90bHXcUU4y8","logo_url":"http://mmbiz.qpic.cn/mmbiz_jpg/MV8dBUmdfs58nc3IXyfLib2LS1rjFpawbibSDm1L0c7L3RHd5J8yqQOjlFDOfG2OoueHoDWcDNQnHviasSicXGiclgQ/0","code_type":"CODE_TYPE_QRCODE","brand_name":"路云家居用品","title":"5折券","date_info":{"type":"DATE_TYPE_FIX_TIME_RANGE","begin_timestamp":1569254400,"end_timestamp":1569772800},"color":"#2c9f67","notice":"明明","description":"狗狗公共","location_id_list":[],"use_limit":1,"get_limit":1,"can_share":true,"can_give_friend":false,"status":"CARD_STATUS_VERIFY_OK","sku":{"quantity":19,"total_quantity":20},"create_time":1569325215,"update_time":1569325225,"area_code_list":[]}
             * discount : 50
             * advanced_info : {"time_limit":[{"type":"MONDAY"},{"type":"TUESDAY"},{"type":"WEDNESDAY"},{"type":"THURSDAY"},{"type":"FRIDAY"},{"type":"SATURDAY"},{"type":"SUNDAY"}],"text_image_list":[],"business_service":[],"consume_share_card_list":[],"abstract":{"icon_url_list":["http://mmbiz.qpic.cn/mmbiz_jpg/MV8dBUmdfs7e3zYM3TToekqichyyA0Y5LOZibWYjGQ465hmd9wWHfA6cylWAVzlA5bxZSvKI3y8Lm1EJOyzMJm8Q/0"]},"share_friends":false}
             */

            private Object base_info;
            private int discount;
            private Object advanced_info;

            public Object getBase_info() {
                return base_info;
            }

            public void setBase_info(Object base_info) {
                this.base_info = base_info;
            }

            public int getDiscount() {
                return discount;
            }

            public void setDiscount(int discount) {
                this.discount = discount;
            }

            public Object getAdvanced_info() {
                return advanced_info;
            }

            public void setAdvanced_info(Object advanced_info) {
                this.advanced_info = advanced_info;
            }

            public static class BaseInfoBean {
                /**
                 * id : pD9sF1Y6-ndvU8ZHC90bHXcUU4y8
                 * logo_url : http://mmbiz.qpic.cn/mmbiz_jpg/MV8dBUmdfs58nc3IXyfLib2LS1rjFpawbibSDm1L0c7L3RHd5J8yqQOjlFDOfG2OoueHoDWcDNQnHviasSicXGiclgQ/0
                 * code_type : CODE_TYPE_QRCODE
                 * brand_name : 路云家居用品
                 * title : 5折券
                 * date_info : {"type":"DATE_TYPE_FIX_TIME_RANGE","begin_timestamp":1569254400,"end_timestamp":1569772800}
                 * color : #2c9f67
                 * notice : 明明
                 * description : 狗狗公共
                 * location_id_list : []
                 * use_limit : 1
                 * get_limit : 1
                 * can_share : true
                 * can_give_friend : false
                 * status : CARD_STATUS_VERIFY_OK
                 * sku : {"quantity":19,"total_quantity":20}
                 * create_time : 1569325215
                 * update_time : 1569325225
                 * area_code_list : []
                 */

                private String id;
                private String logo_url;
                private String code_type;
                private String brand_name;
                private String title;
                private DateInfoBean date_info;
                private String color;
                private String notice;
                private String description;
                private int use_limit;
                private int get_limit;
                private boolean can_share;
                private boolean can_give_friend;
                private String status;
                private SkuBean sku;
                private int create_time;
                private int update_time;
                private List<?> location_id_list;
                private List<?> area_code_list;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getLogo_url() {
                    return logo_url;
                }

                public void setLogo_url(String logo_url) {
                    this.logo_url = logo_url;
                }

                public String getCode_type() {
                    return code_type;
                }

                public void setCode_type(String code_type) {
                    this.code_type = code_type;
                }

                public String getBrand_name() {
                    return brand_name;
                }

                public void setBrand_name(String brand_name) {
                    this.brand_name = brand_name;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public DateInfoBean getDate_info() {
                    return date_info;
                }

                public void setDate_info(DateInfoBean date_info) {
                    this.date_info = date_info;
                }

                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }

                public String getNotice() {
                    return notice;
                }

                public void setNotice(String notice) {
                    this.notice = notice;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getUse_limit() {
                    return use_limit;
                }

                public void setUse_limit(int use_limit) {
                    this.use_limit = use_limit;
                }

                public int getGet_limit() {
                    return get_limit;
                }

                public void setGet_limit(int get_limit) {
                    this.get_limit = get_limit;
                }

                public boolean isCan_share() {
                    return can_share;
                }

                public void setCan_share(boolean can_share) {
                    this.can_share = can_share;
                }

                public boolean isCan_give_friend() {
                    return can_give_friend;
                }

                public void setCan_give_friend(boolean can_give_friend) {
                    this.can_give_friend = can_give_friend;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public SkuBean getSku() {
                    return sku;
                }

                public void setSku(SkuBean sku) {
                    this.sku = sku;
                }

                public int getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(int create_time) {
                    this.create_time = create_time;
                }

                public int getUpdate_time() {
                    return update_time;
                }

                public void setUpdate_time(int update_time) {
                    this.update_time = update_time;
                }

                public List<?> getLocation_id_list() {
                    return location_id_list;
                }

                public void setLocation_id_list(List<?> location_id_list) {
                    this.location_id_list = location_id_list;
                }

                public List<?> getArea_code_list() {
                    return area_code_list;
                }

                public void setArea_code_list(List<?> area_code_list) {
                    this.area_code_list = area_code_list;
                }

                public static class DateInfoBean {
                    /**
                     * type : DATE_TYPE_FIX_TIME_RANGE
                     * begin_timestamp : 1569254400
                     * end_timestamp : 1569772800
                     */

                    private String type;
                    private int begin_timestamp;
                    private int end_timestamp;

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public int getBegin_timestamp() {
                        return begin_timestamp;
                    }

                    public void setBegin_timestamp(int begin_timestamp) {
                        this.begin_timestamp = begin_timestamp;
                    }

                    public int getEnd_timestamp() {
                        return end_timestamp;
                    }

                    public void setEnd_timestamp(int end_timestamp) {
                        this.end_timestamp = end_timestamp;
                    }
                }

                public static class SkuBean {
                    /**
                     * quantity : 19
                     * total_quantity : 20
                     */

                    private int quantity;
                    private int total_quantity;

                    public int getQuantity() {
                        return quantity;
                    }

                    public void setQuantity(int quantity) {
                        this.quantity = quantity;
                    }

                    public int getTotal_quantity() {
                        return total_quantity;
                    }

                    public void setTotal_quantity(int total_quantity) {
                        this.total_quantity = total_quantity;
                    }
                }
            }

            public static class AdvancedInfoBean {
                /**
                 * time_limit : [{"type":"MONDAY"},{"type":"TUESDAY"},{"type":"WEDNESDAY"},{"type":"THURSDAY"},{"type":"FRIDAY"},{"type":"SATURDAY"},{"type":"SUNDAY"}]
                 * text_image_list : []
                 * business_service : []
                 * consume_share_card_list : []
                 * abstract : {"icon_url_list":["http://mmbiz.qpic.cn/mmbiz_jpg/MV8dBUmdfs7e3zYM3TToekqichyyA0Y5LOZibWYjGQ465hmd9wWHfA6cylWAVzlA5bxZSvKI3y8Lm1EJOyzMJm8Q/0"]}
                 * share_friends : false
                 */

                @SerializedName("abstract")
                private AbstractBean abstractX;
                private boolean share_friends;
                private List<TimeLimitBean> time_limit;
                private List<?> text_image_list;
                private List<?> business_service;
                private List<?> consume_share_card_list;

                public AbstractBean getAbstractX() {
                    return abstractX;
                }

                public void setAbstractX(AbstractBean abstractX) {
                    this.abstractX = abstractX;
                }

                public boolean isShare_friends() {
                    return share_friends;
                }

                public void setShare_friends(boolean share_friends) {
                    this.share_friends = share_friends;
                }

                public List<TimeLimitBean> getTime_limit() {
                    return time_limit;
                }

                public void setTime_limit(List<TimeLimitBean> time_limit) {
                    this.time_limit = time_limit;
                }

                public List<?> getText_image_list() {
                    return text_image_list;
                }

                public void setText_image_list(List<?> text_image_list) {
                    this.text_image_list = text_image_list;
                }

                public List<?> getBusiness_service() {
                    return business_service;
                }

                public void setBusiness_service(List<?> business_service) {
                    this.business_service = business_service;
                }

                public List<?> getConsume_share_card_list() {
                    return consume_share_card_list;
                }

                public void setConsume_share_card_list(List<?> consume_share_card_list) {
                    this.consume_share_card_list = consume_share_card_list;
                }

                public static class AbstractBean {
                    private List<String> icon_url_list;

                    public List<String> getIcon_url_list() {
                        return icon_url_list;
                    }

                    public void setIcon_url_list(List<String> icon_url_list) {
                        this.icon_url_list = icon_url_list;
                    }
                }

                public static class TimeLimitBean {
                    /**
                     * type : MONDAY
                     */

                    private String type;

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }
                }
            }
        }
    }
}
