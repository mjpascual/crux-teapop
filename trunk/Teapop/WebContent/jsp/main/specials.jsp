<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- start categories -->
<div id="categories" class="grid_16">
	<ul id="specials_category_links" class="category_links">
		<s:iterator status="status" value="specials.promos">
			<li><a class="category_link"
				href='#promolink<s:property value="%{#status.index}" />'> <s:property
						value="name" />
			</a></li>
		</s:iterator>
	</ul>
</div>
<!--  end categories -->

<!-- start menu -->
<div id="specials_wrapper" class="grid_16 menu">
	<s:iterator status="status" value="specials.promos">
		<!-- category item -->
		<div class="category" id="promolink<s:property value="%{#status.index}"/>">
			<div>
				<div style="float: left">
					<img class="promo_photo" src="images/promos/<s:property value="image"/>">
				</div>
			</div>

			<div class="promoTitle_container">
				<s:property value="name" />

				<div class="promoDetails">
					<s:property value="desc" />
				</div>
			</div>
			<br> <br> <br>

		</div>
		<div class="clear"></div>

		<!-- end category item -->

		<img class="category_divider" src="images/category_divider.png" />
	</s:iterator>
</div>

<script type="text/javascript">
	 $(document).ready( function(){
		 EventHandler.initCategoryLinks("specials_category_links");
	 });
</script>