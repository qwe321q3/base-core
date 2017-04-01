/**
 * www.tydic.com Inc.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package com.tydic.base.core.common.enums;

/**
 * 业务异常
 * @author tianshuo
 * @version Id: ValidationException.java, v 0.1 2016/7/28 0028 9:47 tianshuo Exp $$
 */
public enum BizErrorCode implements ErrorCode {
    /**
     * 无证商户校验失败
     */
    UNLICENSED_MERCHANT_VALID_ERROR("UNLICENSED_MERCHANT_VALID_ERROR","无证商户校验失败"),
    /**
     * 商户类型校验失败
     */
    MERCHANT_TYPE_VALID_ERROR("MERCHANT_TYPE_VALID_ERROR","无证商户校验失败"),
    /**
     * 帮助中心分类查询失败
     */
    HELP_CATEGORY_QUERY_ERROR("HELP_CATEGORY_QUERY_ERROR","帮助中心分类查询失败"),
    /**
     * 帮助中心分页查询失败
     */
    HELP_CENTER_QUERY_ERROR("HELP_CENTER_QUERY_ERROR","帮助中心分页查询失败"),
    /**
     * 调用远程服务返回结果为空，定义为系统异常，可尝试重新发起
     */
    REMOTE_RESPONSE_NULL_EXCEPTION("REMOTE_RESPONSE_NULL_EXCEPTION", "系统异常，请确认请求是否成功再尝试发起"),

    /**
     * 请求远程服务超时,最常见的RpcException，如果是dubbo调用超时则返回系统超时
     */
    REMOTE_TIMEOUT_ERROR("REMOTE_TIMEOUT_ERROR", "请求远程服务超时"),

    /**
     * 新增工单认领失败
     */
    ADD_ORDER_ERROR("ADD_ORDER_ERROR", "新增工单认领失败"),

    /**
     * 查询数据已存在返回的异常信息
     */
    DATA_EXIST_ERROR("DATA_EXIST_ERROR", "数据已存在"),

    /**
     * 执行数据库操作发生异常,具体查看数据库返回的异常信息
     */
    DATA_BASE_ERROR("DATA_BASE_ERROR", "数据库操作异常"),

    /**
     * 数据更新失败
     */
    DATA_UPDATE_ERROR("DATA_UPDATE_ERROR", "数据更新失败"),

    /**
     * 参数校验不通过 ，未明确具体参数的情况使用该枚举
     */
    PARAMETER_VALID_NOT_PASS("PARAMETER_VALID_NOT_PASS", "参数校验不通过"),
    /**
     * 参数校验不通过 ，有明确具体参数错误原因
     */
    PARAMETER_VALID_NOT_PASS_BY("PARAMETER_VALID_NOT_PASS_BY", "参数校验不通过,{0}"),
    /**
     * 参数对象内部属性校验不通过 ，不同于参数对象本身校验
     */
    PARAMETER_FIELD_VALID_NOT_PASS("PARAMETER_FIELD_VALID_NOT_PASS", " 参数对象内部属性校验不通过"),

    /**
     * 参数为空（含null）是非法的
     */
    BLANK_IS_ILLEGAL_PARAM("BLANK_IS_ILLEGAL_PARAM", "参数为空（含null）是非法的"),

    /**
     * 参数为null（不含空字符串）是非法的
     */
    NULL_IS_ILLEGAL_PARAM("NULL_IS_ILLEGAL_PARAM", "参数为null是非法的"),
    /**
     * fastdfs 文件上传失败
     */
    FILE_UPLOAD_ERROR("FILE_UPLOAD_ERROR", "文件上传失败"),
    /**
     * fastdfs 文件更新失败
     */
    FILE_MODIFY_ERROR("FILE_MODIFY_ERROR", "文件更新失败"),
    /**
     * fastdfs 文件下传失败
     */
    FILE_DOWNLOAD_ERROR("FILE_DOWNLOAD_ERROR", "文件下传失败"),
    /**
     * fastdfs 文件删除失败
     */
    FILE_DELETE_ERROR("FILE_DELETE_ERROR", "文件删除失败"),
    /**
     * fastdfs 文件不存在
     */
    FILE_NOT_EXIT("FILE_NOT_EXIT", "文件不存在"),
    /**
     * 文件类型不正确
     */
    FILE_FILETYPE_ERROR("800008", "文件类型不正确"),
    /**
     * 根据查询参数没有找到匹配的记录
     */
    EMPTY_QUERY_RESULT("EMPTY_QUERY_RESULT", "查询结果为空"),

    API_INVOKE_FAIL("API_INVOKE_FAIL", "接口返回同步失败"),
    /**
     * 帮助中心问题新增失败
     */
    HELP_CENTER_ADD_ERROR("HELP_CENTER_ADD_ERROR","帮助中心问题新增失败"),

    HELP_CENTER_UPDATE_ERROR("HELP_CENTER_UPDATE_ERROR","帮助中心问题修改失败"),

    HELP_CENTER_SEQ_CHANGE_ERROR("HELP_CENTER_SEQ_CHANGE_ERROR","帮助中心热门问题序列修改失败"),
    /**
     * 修改签约联系信息失败
     */
    UPDATE_SIGN_CONTACT_INFO_ERROR("UPDATE_SIGN_CONTACT_INFO_ERROR","修改签约联系信息失败"),
    /**
     * 工单认领
     */
    ADD_ORDER_CLAIM_ERROR("ADD_ORDER_CLAIM_ERROR","新增工单认领失败"),

    UPDATE_ORDER_CLAIM_ERROR("UPDATE_ORDER_CLAIM_ERROR","重新指派工单失败"),

    CANCEL_ORDER_CLAIM_ERROR("CANCEL_ORDER_CLAIM_ERROR","取消工单失败"),
    /**
     * 产品申请信息已存在
     */
    EXIST_PROD_APPLY("EXIST_PROD_APPLY","已存在申请信息，请不要重复申请!"),

    /**
     * 该错误码一般是在系统内部处理过程中出现不需要外部系统明确了解（如模型转化错误，非对外服务参数校验不同，内部BUG）时设定的错误码
     */
    SYSTEM_INNER_ERROR("SYSTEM_INNER_ERROR", "系统内部错误"),

    SIGN_STATUS_ERROR("SIGN_STATUS_ERROR", "kafka回调接口查询本地签约申请记录状态异常！"),

    CONTRACT_CIF_AGREE("CONTRACT_CIF_AGREE", "调用CIF查询协议(协议与协议组成)认证接口失败！"),

    CONTRACT_CIF_CONTRACT("CONTRACT_CIF_CONTRACT", "调用CIF查询联系人信息认证接口失败！"),

    CONTRACT_CIF_CUSTOMER("CONTRACT_CIF_CUSTOMER", "调用CIF查询商户信息认证接口失败！"),

    FAIL_ENCRYPT("FAIL_ENCRYPT", "敏感数据加密失败"),

    /**
     * areaAddress解析失败
     */
    AREA_ADDRESS_PARSE_FAIL("AREA_ADDRESS_PARSE_FAIL","营业地址所属区域解析失败"),

    CUT_CUSTOMER_NAME_FAIL("CUT_CUSTOMER_NAME_FAIL","截取商户名失败"),

    MERCHANT_NOT_EXISTS("MERCHANT_NOT_EXISTS", "商户不存在"),

    MERCHANT_DISABLE("MERCHANT_DISABLE", "商户状态不可用"),

    AGREEMENT_ACCEPT_EXISTS("AGREEMENT_ACCEPT_EXISTS","签约受理数据已存在"),

    AGREEMENT_ACCEPT_STEP1("AGREEMENT_ACCEPT_STEP1", "签约受理申请信息生成失败");
    /**
     * 异常码
     */
    private String code;

    /**
     * 异常描述
     */
    private String desc;

    BizErrorCode(String code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }

}
