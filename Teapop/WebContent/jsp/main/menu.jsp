<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="header_text">Our Menu</div>

<div id="menu_box">
	<div id="menu_wrapper" class="menu">
	
		<s:if test="menu != null">

		<div id="categories" class="categories">
			<ul id="menu_section_links" class="category_links">
				<li><a title="beverge_wrapper" id="initial_load" class="category_link beverage active">
						Beverages </a></li>
				<li><a title="additional_wrapper" class="category_link additional">
						Additionals </a></li>
			</ul>
		</div>
		
		
		<div id="beverge_wrapper" class="menu_section_wrapper initialdisplay">
			<s:if test="menu.beveragesSection.categories.size > 0">
			<div id="beverage_menu_categories" class="menu_categories">
				<s:iterator status="status" value="menu.beveragesSection.categories">
					<a class="category_link"
						data-slide-index='<s:property value="%{#status.index}" />'>
						<div>
							<s:property value="name" />
						</div>
					</a>
				</s:iterator>
			</div>
			</s:if>
			
			<div class="menu_border" class="">
				<ul id="beverage_content_slider" class="contentSliderMenu">
					<s:if test="menu.beveragesSection.categories.size > 0">
					<s:iterator status="status"
						value="menu.beveragesSection.categories">
						<li>
							<!-- category item -->
							<div class="category"
								id="itemlink<s:property value="%{#status.index}"/>">
								<div class="category_photo">
									<img src="images/categories/<s:property value="image"/>">
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
								<s:if test="showSML">
									<div class="serving">
										<div class="price">L</div>
										<div class="price">M</div>
										<div class="price">S</div>
										<div class="clear"></div>
									</div>
								</s:if>

								<s:iterator value="items">

									<div class="item">
										<div class="name">
											<s:if test="featured">
												<img class="bestseller" src="images/bestseller.png"/>
											</s:if>
											<strong><s:property value="name" /> </strong>
										</div>
										<div class="description">
											<s:property value="desc" />
										</div>

										<s:if test="showSML">
											<div class="price">
												<s:if test="price.large == 0">
										-
									</s:if>
												<s:else>
													<s:text name="format.money">
														<s:param value="price.large" />
													</s:text>
												</s:else>

											</div>
											<div class="price">
												<s:if test="price.regular == 0">
										-
									</s:if>
												<s:else>
													<s:text name="format.money">
														<s:param value="price.regular" />
													</s:text>
												</s:else>
											</div>
											<div class="price">
												<s:if test="price.small == 0">
										-
									</s:if>
												<s:else>
													<s:text name="format.money">
														<s:param value="price.small" />
													</s:text>
												</s:else>
											</div>
										</s:if>
										<s:else>
											<div class="price">
												<s:if test="price.regular == 0">
										-
								</s:if>
												<s:else>
													<s:text name="format.money">
														<s:param value="price.regular" />
													</s:text>
												</s:else>
											</div>
										</s:else>
										<div class="clear"></div>
									</div>
								</s:iterator>
								<div class="clear"></div>

								<!-- end category item -->
								<br />

							</div>
						</li>
					</s:iterator>
					</s:if>
					<s:else>
						There are no items added in this section yet.
					</s:else>
				</ul>
			</div>
		
		</div>


		<%-- ADDITIONAL WRAPPER --%>

		<div id="additional_wrapper" class="menu_section_wrapper">
			<s:if test="menu.additionalSection.categories.size > 0">
			<div id="additional_menu_categories" class="menu_categories">
				<s:iterator status="status"
					value="menu.additionalSection.categories">
					<a class="category_link"
						data-slide-index='<s:property value="%{#status.index}" />'>
						<div>
							<s:property value="name" />
						</div>
					</a>
				</s:iterator>
			</div>
			</s:if>

			<div class="menu_border">
				<ul id="additional_content_slider" class="contentSliderMenu">
					<s:if test="menu.additionalSection.categories.size > 0">
					<s:iterator status="status"
						value="menu.additionalSection.categories">
						<li>
							<!-- category item -->
							<div class="category"
								id="itemlink<s:property value="%{#status.index}"/>">
								<div class="category_photo">
									<img src="images/categories/<s:property value="image"/>">
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
								<s:if test="showSML">
									<div class="serving">
										<div class="price">L</div>
										<div class="price">M</div>
										<div class="price">S</div>
										<div class="clear"></div>
									</div>
								</s:if>

								<s:iterator value="items">

									<div class="item">
										<div class="name">
											<s:if test="featured">
												<img class="bestseller" src="images/bestseller.png"/>
											</s:if>
											<strong><s:property value="name" /> </strong>
										</div>
										<div class="description">
											<s:property value="desc" />
										</div>

										<s:if test="showSML">
											<div class="price">
												<s:if test="price.large == 0">
										-
									</s:if>
												<s:else>
													<s:text name="format.money">
														<s:param value="price.large" />
													</s:text>
												</s:else>

											</div>
											<div class="price">
												<s:if test="price.regular == 0">
										-
									</s:if>
												<s:else>
													<s:text name="format.money">
														<s:param value="price.regular" />
													</s:text>
												</s:else>
											</div>
											<div class="price">
												<s:if test="price.small == 0">
										-
									</s:if>
												<s:else>
													<s:text name="format.money">
														<s:param value="price.small" />
													</s:text>
												</s:else>
											</div>
										</s:if>
										<s:else>
											<div class="price">
												<s:if test="price.regular == 0">
										-
								</s:if>
												<s:else>
													<s:text name="format.money">
														<s:param value="price.regular" />
													</s:text>
												</s:else>
											</div>
										</s:else>
										<div class="clear"></div>
									</div>
								</s:iterator>
								<div class="clear"></div>

								<!-- end category item -->
								<br />

							</div>

						</li>
					</s:iterator>
					</s:if>
					<s:else>
						There are no items added in this section yet.
					</s:else>
				</ul>
			</div>
		</div>
		</s:if>
		<s:else>
			<br/>
			<center>
				There was a problem with retrieving the Menu. Please try again later.
			</center>
		</s:else>
	</div>
</div>

<script type="text/javascript">
	var sliderConfig = [ {
		id : "#beverage_content_slider",
		pagerId : "#beverage_menu_categories",
		slider : null
	}, {
		id : "#additional_content_slider",
		pagerId : "#additional_menu_categories",
		slider : null
	}, ];
	
	$(document).ready(function() {
		EventHandler.initContentToggler("#menu_section_links",
						".menu_section_wrapper");
	});
</script>






