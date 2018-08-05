$(function() {
	//solving the active menu problem
	switch(menu){
	
	case 'Home':
		$('#home').addClass('active');
		break;
	
	case 'About Us':
		$('#about').addClass('active');
		break;
	
	case 'View Products':
		$('#listProducts').addClass('active');
		break;
		
	case 'Offer Zone':
		$('#offerZone').addClass('active');
		break;
		
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
		
	default:
		$('#home').addClass('active');
	break;
	
	}
	
})