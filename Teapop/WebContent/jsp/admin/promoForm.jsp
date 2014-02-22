<section class="category">
	<header>
		Category Management
	</header>
	<article>
		<div class="formAdd category_add">
			<h3>Add New Promo</h3><hr><br>
			<form action="addPromo" method="post">
				<div>
					<label for="promoName">Promo Name:</label>
					<input type="text" id="promoName" name="promo.name" maxlength="35" autofocus required>
				</div>
				<div>
					<label for="promoCode">Promo Code:</label>
					<input type="text" id="promoCode" name="promo.promoCode" maxlength="35">
				</div>
				<div>
					<label for="promoDesc">Promo Description:</label>
					<textarea name="promo.desc" rows="6" maxlength="250" required></textarea>
				</div>
				<div>
				 	<label for="image_file">Category Image: </label>
				 	<input type="file" name="promo.image" id="image_file" />
				</div>
				<input class="button" type="submit" value="Save">
			</form>
		</div>
	</article>
</section>