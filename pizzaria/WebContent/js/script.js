//Modal Question

$('.novo-pedido').click(function(){
	$('#modal-ask').toggle("slide");
});
$('#close-ask').click(function(){
	$('#modal-ask').toggle("slide");
});

//Modal Register

$('#sim').click(function(){
	$('#modal-ask').toggle("slide");
	$('#modal-cadastro').toggle("slide");
});
$('#close-cadastro').click(function(){
	$('#modal-cadastro').toggle("slide");
});

//Status Nav

	//Slider
function animate(posit){
	$('.a').animate({
		left: (posit + "vw")
	}, 500);
	$('.b').animate({
		left: (posit + 100 + "vw")
	}, 500);
	$('.c').animate({
		left: (posit + 200 + "vw")
	}, 500);
	$('.d').animate({
		left: (posit + 300 + "vw")
	}, 500);
	$('.e').animate({
		left: (posit + 400 + "vw")
	}, 500);
}

	//Nav FX
function newCss(element, stat){
	$('.on').css("background-image", "none");
	$('.status').removeClass("on");
	$(element).addClass("on");
	$('.on').css("background-image", ("url(footage/status-icon-" + stat + ".png)"));
}

	//Logics
$('#s-aguardando').click(function(){
	var posit = 50;
	animate(posit);
	newCss('#s-aguardando', "1");
});
$('#s-montando').click(function(){
	var posit = -50;
	animate(posit);
	newCss('#s-montando', "2");
});
$('#s-assando').click(function(){
	var posit = -150;
	animate(posit);
	newCss('#s-assando', "3");
});
$('#s-saiu').click(function(){
	var posit = -250;
	animate(posit);
	newCss('#s-saiu', "4");
});
$('#s-entregue').click(function(){
	var posit = -350;
	animate(posit);
	newCss('#s-entregue', "5");
});

//Client Register

	//Entrada Form
$('#cliente-trigger').click(function(){
	event.stopPropagation();

	$(this).fadeToggle("fast", function(){
		$('#cliente-cadastro').show();
	});

});

	//Saída Form
$('#close-client-register').click(function(){

	$('#cliente-cadastro').fadeToggle("fast", function(){
		$('#cliente-trigger').show();
	});
	
});

//Search Bar Display

	//Entada Search
$('#search-trigger').click(function(){
	event.stopPropagation();

	$('.theader').css("display", "none");
	$('.search').css("display", "table-row");
});
	//Saida Search
$('#close-search').click(function(){
	$('.search').css("display", "none");
	$('.theader').css("display", "table-row");
});
	
	//Click fora cancel
$('.search').click(function(){
	event.stopPropagation();
});

$('#cliente-cadastro').click(function(){
	event.stopPropagation();
});
	
	//Click fora
$(window).click(function(){
	$('.theader').css("display", "table-row");
	$('.search').css("display", "none");
	
	if ($('#cliente-trigger').is(":hidden")) {
		$('#cliente-cadastro').fadeToggle("fast", function(){
			$('#cliente-trigger').show();
		});
	}
});

//Pedido Hover
$(".pedido").hover(function(){

	var id = (this).id;

	var theElements = $('#'+id).find('.pedido-hover');

    var select = $(theElements).fadeIn().find('#select');

    $(select).click(function(id){
    	var parent = this.parentElement.parentElement.id;
    	$('#'+parent).css("display", "none");
    });

    }, function(){
	
	var id = (this).id;

	var theElements = $('#'+id).find('.pedido-hover');
    
    $(theElements).fadeOut();
});

//Input Masks
$('#phone-input').mask('(00)0000-0000');