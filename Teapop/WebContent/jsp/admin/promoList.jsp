<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section class="category">
	<header>
		Promo Management
	</header>
	<article>
		<table id="category-table" class="table">
			<thead>
				<tr>
					<th colspan="5">
						<s:if test="%{editSuccessful}">
							<span id="editPromoMessage"class="addSuccessful">
							 	EDIT SUCCESSFUL
						</span>
						</s:if>
						<s:if test="%{editFailed}">
							<span id="editPromoMessage"class="addFailed">
							 	EDIT FAILED
						</span>
						</s:if>	
						
						<button class="btn pull-right"><span class="icon-plus"></span>&nbsp;Add New Promo</button>
					</th>
				</tr>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
					<th>Code</th>
					<th>Functions</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator status="status" value="specials.promos">
						<tr>
							<td id="promoId<s:property value='%{#status.index}'/>"><s:property value="promoId"/></td>
							<td id="promoName<s:property value='%{#status.index}'/>"><s:property value="name"/></td>
							<td id="promoDesc<s:property value='%{#status.index}'/>"><s:property value="desc"/></td>
							<td id="promoCode<s:property value='%{#status.index}'/>"><s:property value="promoCode"/></td>
							<td>
								<div class="btn-group">
									<a class="btn btn-mini" onclick="javascript:editPromo(<s:property value='%{#status.index}'/>)"><span class="icon-pencil"></span></a>
									<a class="btn btn-mini"><span class="icon-trash"></span></a>
								</div>
							</td>
							
						</tr>
				</s:iterator>
			</tbody>
		</table>
	</article>
</section>

<script type="text/javascript">
	function editPromo(index){
		var promoId = $("#promoId" + index).text();
		var promoName = $("#promoName" + index).text();
		var promoDesc = $("#promoDesc" + index).text();
		var promoCode = $("#promoCode" + index).text();
		
		addPromoPost("displayEditPromo", {promoId : promoId, promoName : promoName, promoDesc : promoDesc, promoCode : promoCode});
	};
	
	function addPromoPost(action, data){
		$.ajax({
			url: action,
		    type: "POST",
		    data: data,
		    error: function(){
		        alert('Admin Error');
		    },
		    success: function(data){         
		    	var $container = $("#body_container");
				$container.empty();
				$container.html(data);
		    }
		});
	};
</script>
