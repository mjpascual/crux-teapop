<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<section class="category printIt">
	<header>
		Print Promo Master List
	</header>
	<article>
		<table id="print-table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Code</th>
					<th>Name</th>
					<th>Image</th>
					<th>Description</th>
					
				</tr>
			</thead>
			<tbody>
				<s:iterator status="status" value="specials.promos">
					<tr>
						<td id="promoId<s:property value='%{#status.index}'/>"><s:property value="promoId"/></td>
						<td id="promoCode<s:property value='%{#status.index}'/>"><s:property value="promoCode"/></td>
						<td id="promoName<s:property value='%{#status.index}'/>"><s:property value="name"/></td>
						<td id="promoCode<s:property value='%{#status.index}'/>"><s:property value="promoCode"/></td>
						<td id="promoDesc<s:property value='%{#status.index}'/>"><s:property value="desc"/></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</article>
</section>
