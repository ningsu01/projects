//package com.xxl.registry.client.model;
//
//import java.util.Objects;
//
///**
// * @author xuxueli 2018-11-30
// */
//public class XxlRegistryParam {
//
//    private String key;
//    private String value;
//
//    public XxlRegistryParam() {
//    }
//    public XxlRegistryParam(String key, String value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    public String getKey() {
//        return key;
//    }
//
//    public void setKey(String key) {
//        this.key = key;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        XxlRegistryParam that = (XxlRegistryParam) o;
//        return Objects.equals(key, that.key) &&
//                Objects.equals(value, that.value);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(key, value);
//    }
//
//    @Override
//    public String toString() {
//        return "XxlRegistryParam{" +
//                "key='" + key + '\'' +
//                ", value='" + value + '\'' +
//                '}';
//    }
//
//}
