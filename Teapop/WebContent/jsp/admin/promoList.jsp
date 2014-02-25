<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<section class="promo">
	<header>
		Promo Management
	</header>
	<article>
		<table id="promo-table" class="promotable">
			<thead>
				<tr>
					<th colspan="5">
						<button class="btn pull-right" id="addPromoSubmit" forward="displayAddPromo"><span class="icon-plus"></span>&nbsp;Add New Promo</button>
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
								   <form id="editPromo" class="smallForm" action="displayEditPromo">
								   		<input type="hidden" name="promoId" value='<s:property value="promoId" />' />
										<a class="btn btn-mini" id="submitPromoEditBtn"><span class="icon-pencil"></span></a>
									</form>
									<form id="deletePromo" class="smallForm" action="deletePromo">
										<input type="hidden" name="promoId" value='<s:property value="promoId" />' />
										<a class="btn btn-mini" id="submitPromoDelBtn"><span class="icon-trash"></span></a>
									</form>
								</div>
							</td>
						</tr>
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
