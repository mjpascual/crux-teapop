<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="header_text">Specials & Promos</div>

<!-- start menu -->
<div id="specials_wrapper" class="menu">
	<div class="menu_border">
		<ul id="contentSliderMenu" class="contentSliderMenu">
			<s:iterator status="status" value="specials.promos">
				<li>
					<!-- category item -->
					<div class="category"
						id="promolink<s:property value="%{#status.index}"/>">
						<div class="promo_photo_container">
							<img title="<s:property value="desc" />" class="promo_photo"
								src="images/promos/<s:property value="image"/>">
						</div>
						<div class="promo_title_desc_container">
							<div class="promoTitle_container">
								<s:property value="name" />
							</div>

							<div class="promoDetails">
								<s:property value="desc" />
							</div>
							<div class="clear"></div>
						</div>
					</div>
				</li>
			</s:iterator>
		</ul>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		EventHandler.initSpecialsSliderLinks(".contentSliderMenu");
	});
</script>