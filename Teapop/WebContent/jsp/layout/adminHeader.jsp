<%@ taglib prefix="s" uri="/struts-tags" %>
<figure>
	<img src="images/admin/logo2.png" title="Logo">
</figure>
<div class="link">
	<a href="#">View website</a>
</div>
<div class="status">
	You're logged in as <strong><s:property value="%{#session['user']}" /></strong>. <a href="#"><strong>Edit your settings</strong></a>, or <a href="logoutUser"><strong>Log out</strong></a>
</div>