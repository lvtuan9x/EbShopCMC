package com.cmc.ebshop.mapper;

import com.cmc.ebshop.dto.response.invoice.InvoiceResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IInvoiceMapper {
    InvoiceResponse getInvoice(@Param("orderId") String orderId);
}