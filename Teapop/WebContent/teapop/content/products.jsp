<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="categories" class="grid_16">
	<ul id="menu_category_links" class="category_links">
		<s:iterator status="status" value="menu.categories">
			<li><a class="category_link" href='#itemlink<s:property value="%{#status.index}" />'>
					<s:property value="name" />
			</a></li>
		</s:iterator>
	</ul>
</div>

<div id="menu_wrapper" class="grid_16 menu">
	<s:iterator status="status" value="menu.categories">
		<!-- category item -->
		<div class="category" id="#itemlink<s:property value="%{#status.index}"/>">
			<div class="category_photo">
				<img src="<s:property value="image"/>">
			</div>
			<div class="category_info">
				<div class="category_name">
					<s:property value="name" />
				</div>
				<div class="category_description">
					<s:property value="desc" />
				</div>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
			<s:iterator value="items">
				<div class="item">
					<div class="name">
						<strong><s:property value="name" /></strong>
					</div>
					<div class="price">
						<s:property value="price" />
					</div>
					<div class="description">
						<s:property value="desc" />
					</div>
					<div class="clear"></div>
				</div>
			</s:iterator>
			<div class="clear"></div>
		</div>
		<!-- end category item -->

		<img class="category_divider" src="images/category_divider.png" />
	</s:iterator>
</div>


<script type="text/javascript">
	function initContent(json) {
		EventHandler.initCategoryLinks("menu_category_links");
	}
</script>






