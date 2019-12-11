<%@include file="/WEB-INF/apps/init.jsp" %>
<%@page import="com.example.demo.dto.ImageDto"%>
<%@include file="/WEB-INF/apps/include/header.jsp" %>

<%
	List<ImageDto> objList = (List<ImageDto>) request.getAttribute("imageList");
%>

<div class="site-section">
	<div class="container">
	
		<div class="row mb-5">
			<div class="col-md-7 text-center mx-auto">
				<!-- <span class="subtitle-39293">My Works</span>
				<h2 class="serif">See My Works</h2> -->
				<form method="post" action="<%=ActionUrlConstant.SEARCH_IMAGE%>">
				
					Search Image: <input name="searchValue" value = "Taylor Swift">
				
					<input type="submit">
				
				</form>

			</div>
		</div>
	
		<div id="posts" class="row no-gutter">
		<c:if test="<%=objList != null %>">
			<%
				for(ImageDto x: objList){
			%>
				<div class="item web col-6 col-sm-6 col-md-6 col-lg-4 col-xl-4 mb-4">
					<a href="<%=x.getUrl() %>" target="blank" class="item-wrap" data-fancybox="gal">
						<span class="icon-search2"></span>
						<img class="img-fluid" src="<%=x.getUrl()%>">
					</a>
				</div>
			<%
				}
			%>
		</c:if>
		<c:if test="<%=objList != null && objList.isEmpty() %>">
		
			<h2 class="serif">Record Not Found</h2>
		
		</c:if>
		</div>
	
	</div>
</div>

<%@include file="/WEB-INF/apps/include/footer.jsp" %>
