<%-- 
    Document   : Left
    Created on : Jul 20, 2023, 9:34:38 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> GENRES</div>
                        <ul class="list-group category_block">
                            <c:forEach items="${listC}" var="o">
                                <li class="list-group-item text-white ${tag == o.cid? "active":""}"><a href="category?cid=${o.cid}">${o.cname}</a></li>
                            </c:forEach>

                        </ul>
                    </div>
                    <div class="card bg-light mb-3">
                        <div class="card-header bg-success text-white text-uppercase">NEW BOOK</div>
                        <div class="card-body">
                            <img class="img-fluid" src="${p.image}" />
                            <h5 class="card-title">${p.name}</h5>
                            <p class="card-text">${p.title}</p>
                            <p class="bloc_left_price">${p.price} $</p>
                        </div>
                    </div>
