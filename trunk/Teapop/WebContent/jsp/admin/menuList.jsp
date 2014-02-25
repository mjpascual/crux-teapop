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
					<th colspan="8"><button class="btn pull-right" id="addMenuSubmit" forward="displayAddMenu"><span class="icon-plus"></span>&nbsp;Add Menu Item</button></th>
				</tr>
				<tr>
					<th>ID</th>
					<th>Menu Name</th>
					<th>Menu Code</th>
					<th>Category</th>
					<th>Price (S-R-L)</th>
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
							<td><s:property value="price.small"/>-<s:property value="price.regular"/>-<s:property value="price.large"/></td>
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
									 <form id="editMenu" class="smallForm" action="displayUpdateMenu">
								   		<input type="hidden" name="itemId" value='<s:property value="itemId" />' />
										<a class="btn btn-mini" id="submitMenuEditBtn"><span class="icon-pencil"></span></a>
									</form>
									<form id="deleteMenu" class="smallForm" action="deleteMenu">
										<input type="hidden" name="itemId" value='<s:property value="itemId" />' />
										<a class="btn btn-mini" id="submitMenuDelBtn"><span class="icon-trash"></span></a>
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
							<td><s:property value="price.small"/>-<s:property value="price.regular"/>-<s:property value="price.large"/></td>
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
									 <form id="editMenu" class="smallForm" action="displayUpdateMenu">
								   		<input type="hidden" name="itemId" value='<s:property value="itemId" />' />
										<a class="btn btn-mini" id="submitMenuEditBtn"><span class="icon-pencil"></span></a>
									</form>
									<form id="deleteMenu" class="smallForm" action="deleteMenu">
										<input type="hidden" name="itemId" value='<s:property value="itemId" />' />
										<a class="btn btn-mini" id="submitMenuDelBtn"><span class="icon-trash"></span></a>
									</form>
								</div>
							</td>
						</tr>
					</s:iterator>
				</s:iterator>
				<s:if test="hasActionErrors()">
					<div class="login_errors">
						<s:actionerror/>
					</div>
				</s:if>
				<s:if test="hasActionMessages()">
					<div class="success_form">
						<s:actionmessage/>
					</div>
				</s:if>
			</tbody>
		</table>
	</article>
</section>