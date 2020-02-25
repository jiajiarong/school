<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="taglibs.jsp" %>


    
    
    <div class="page_c">
        <span class="l inb_a">
        </span>
        <span class="r page">
            <input type="hidden" id="pageNo" name="pageNo" />
            <input type="hidden" value="${page.totalCount}" id="totalCount" name="totalCount" />
            <input type="hidden" value="${page.pageNo}" id="currentPageNo" name="currentPageNo" />
            <input type="hidden" value="${page.totalPage}" id="totalPage" name="totalPage" />
             <input type="hidden" value="${page.pageSize}" id="pageSize" name="pageSize" />
                    共<var id="pagePiece" class="orange">${page.totalCount}</var>条<var id="pageTotal">${page.pageNo}/${page.totalPage}</var>
            <a href="javascript:void(0);" id="first" class="hidden">首页</a>
            <a href="javascript:void(0);" id="previous" class="hidden" title="上一页">上一页</a>
            <a href="javascript:void(0);" id="next" class="hidden" title="下一页">下一页</a>
            <a href="javascript:void(0);" id="last" class="hidden" title="下一页">尾页</a>
        </span>
    </div>