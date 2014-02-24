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
										<a class="btn btn-mini"><span class="icon-pencil"></span></a>
										<a class="btn btn-mini"><span class="icon-trash"></span></a>
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
										<a class="btn btn-mini" ><span class="icon-pencil"></span></a>
										<a class="btn btn-mini" onclick="javascript:deleteMenu(<s:property value='itemId'/>)"><span class="icon-trash"></span></a>
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
function menuPost(action, data){
	alert(data);
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

function deleteMenu(itemId){
	menuPost("deleteMenu", {itemId : itemId});
}
</script>