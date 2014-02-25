<%@ taglib prefix="s" uri="/struts-tags" %>
<figure>
	<img src="images/admin/logo2.png" title="Logo">
</figure>
<div class="link">
</div>
<div class="status">
	You're logged in as <strong><s:property value="%{#session['user']}" /></strong>.&nbsp;&nbsp;<a href="logoutUser"><strong>Log out</strong></a>
</div>