<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section class="menu">
	<header>
		Menu Management
	</header>
	<article>
		<table id="menu-table" class="table">
			<thead>
				<tr>
					<th colspan="8"><button class="btn pull-right"><span class="icon-plus"></span>&nbsp;Add Menu Item</button></th>
				</tr>
				<tr>
					<th>ID</th>
					<th>Menu Name</th>
					<th>Menu Code</th>
					<th>Category</th>
					<th>Price</th>
					<th>Featured</th>
					<th>Hidden</th>
					<th>Functions</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator status="status" value="menu.additionalSection.categories">
					<s:iterator value="items" status="itemStatus">
						<tr>
							<td><s:property value="itemId"/></td>
							<td><s:property value="name"/></td>
							<td><s:property value="itemCode"/></td>
							<td><s:property value="category"/></td>
							<td><s:property value="price.small"/>-<s:property value="price.large"/></td>
							<td>
								<s:if test="%{featured}">
									Y
								</s:if>
								<s:else>
									N
								</s:else>
							</td>
							<td>	
								<s:if test="%{hidden}">
									Y
								</s:if>
								<s:else>
									N
								</s:else>
							</td>
							<td>
								<div class="btn-group">
									<form id="update" class="smallForm" action="updateMenu">
										<input type="hidden" name="itemId" value='<s:property value="itemId" />' />
										<a class="btn btn-mini" id="submitEditBtn"><span class="icon-pencil"></span></a>
									</form>
									<form id="delete" class="smallForm" action="deleteMenu">
										<input type="hidden" name="itemId" value='<s:property value="itemId" />' />
										<a class="btn btn-mini" id="submitDelMenuBtn" onclick="javascript:deleteMenu(<s:property value='itemId'/>)"><span class="icon-trash"></span></a>
									</form>
								</div>
							</td>
						</tr>
					</s:iterator>
				</s:iterator>
				
				<s:iterator status="status" value="menu.beveragesSection.categories">
					<s:iterator value="items" status="itemStatus">
						<tr>
							<td><s:property value="itemId"/></td>
							<td><s:property value="name"/></td>
							<td><s:property value="itemCode"/></td>
							<td><s:property value="category"/></td>
							<td><s:property value="price.small"/>-<s:property value="price.large"/></td>
							<td>
								<s:if test="%{featured}">
									Y
								</s:if>
								<s:else>
									N
								</s:else>
							</td>
							<td>	
								<s:if test="%{hidden}">
									Y
								</s:if>
								<s:else>
									N
								</s:else>
							</td>
							<td>
								<div class="btn-group">
									<form id="update" class="smallForm">
										<input type="hidden" name="itemId" value='<s:property value="itemId" />' />
										<a class="btn btn-mini" id="submitEditBtn"><span class="icon-pencil"></span></a>
									</form>
									<form id="delete" class="smallForm">
										<input type="hidden" name="itemId" id="itemId<s:property value='%{itemStatus.index}'/>" value='<s:property value="itemId" />' />
										<a class="btn btn-mini" id="submitDelMenuBtn" onclick="javascript:deleteMenu(<s:property value='%{itemStatus.index}'/>)"><span class="icon-trash"></span></a>
									</form>
								</div>
							</td>
						</tr>
					</s:iterator>
				</s:iterator>
			</tbody>
		</table>
	</article>
</section>
<script type="text/javascript">
function deleteMenu(index){
	var itemId = $("#itemId" + index).text();
	menuPost("deleteMenu", {itemId : 2});
}

function menuPost(action, data){
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