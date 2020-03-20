// on input/text enter--------------------------------------------------------------------------------------
$('.usrInput').on('keyup keypress', function (e) {
	var keyCode = e.keyCode || e.which;
	var text = $(".usrInput").val();
	if (keyCode === 13) {
		if (text == "" || $.trim(text) == '') {
			e.preventDefault();
			return false;
		} else {
			$(".usrInput").focus();
			setUserResponse(text);
			send(text,"0");
			e.preventDefault();
			return false;
		}
	}
});

//on input/text Click--------------------------------------------------------------------------------------
$('#send_Msg').on('click', function (e) {
	var text = $(".usrInput").val();
		if (text == "" || $.trim(text) == '') {
			e.preventDefault();
			return false;
		} else {
			$(".usrInput").focus();
			setUserResponse(text);
			send(text,"0");
			e.preventDefault();
			return false;
	}
});
//------------------------------------- Set user response------------------------------------
function setUserResponse(val) {

	var UserResponse = '<img class="userAvatar" src=' + "./img/userAvatar.jpg" + '><p class="userMsg">' + val + ' </p><div class="clearfix"></div>';
	$(UserResponse).appendTo('.chats').show('slow');
	$(".usrInput").val('');
	scrollToBottomOfResults();
	$('.suggestions').remove();
}

//---------------------------------- Scroll to the bottom of the chats-------------------------------
function scrollToBottomOfResults() {
	var terminalResultsDiv = document.getElementById('chats');
	terminalResultsDiv.scrollTop = terminalResultsDiv.scrollHeight;
}

function send(message,payload) {
	console.log("User Message:", message)
	$.ajax({
		url: 'api/sendInput',
		type: 'POST',
		data: {"inputmessage": message,"sender": "Me","payload": payload},
		dataType: 'json',
		success: function (data, textStatus) {
			console.log("Rasa Response: ", data, "\n Status:", textStatus)
			if(data.responseArray != null){
				setBotResponse(data.responseArray);
				
				//console.log("Rasa data.responseArray: ", data.responseArray, "\n Status:", textStatus)
			}
			
		},
		error: function (errorMessage) {
			setBotResponse("");
			console.log('Error' + errorMessage);

		}
	});
}


//------------------------------------ Set bot response -------------------------------------
function setBotResponse(val) {
	//setTimeout(function () {
	//console.log("val----->"+val);
	//console.log("-val.length--"+val.length);
		if (val.length < 1) {
			//if there is no response from Rasa
			msg = 'I couldn\'t get that. Let\' try something else!';

			var BotResponse = '<img class="botAvatar" src="./img/botAvatar.png"><p class="botMsg">' + msg + '</p><div class="clearfix"></div>';
			$(BotResponse).appendTo('.chats').hide().fadeIn(1000);

		} else {
			//if we get response from Rasa
			for (i = 0; i < val.length; i++) {
				//check if there is text message
				console.log("text-->"+val[i].hasOwnProperty("text"));
				if (val[i].hasOwnProperty("text") && val[i].text !=null ) {
					var BotResponse = '<img class="botAvatar" src="./img/botAvatar.png"><p class="botMsg">' + val[i].text + '</p><div class="clearfix"></div>';
					$(BotResponse).appendTo('.chats').hide().fadeIn(1000);
				}else{
					var BotResponse = '<img class="botAvatar" src="./img/botAvatar.png"><p class="botMsg">Select</p><div class="clearfix"></div>';
					$(BotResponse).appendTo('.chats').hide().fadeIn(1000);
				}

				//check if there is image
				if (val[i].hasOwnProperty("image")) {
					var BotResponse = '<div class="singleCard">' +
						'<img class="imgcard" src="' + val[i].image + '">' +
						'</div><div class="clearfix">'
					$(BotResponse).appendTo('.chats').hide().fadeIn(1000);
				}

				//check if there is  button message
				if (val[i].hasOwnProperty("buttons")) {
					addSuggestion(val[i].buttons);
				}else{
					$(".usrInput").attr("disabled",false);
				}

			}
			scrollToBottomOfResults();
		}

	//}, 500);
}


// ------------------------------------------ Toggle chatbot -----------------------------------------------
$('#profile_div').click(function () {
	$('.profile_div').toggle();
	$('.widget').toggle();
	scrollToBottomOfResults();
	startChat();
});

$('#close').click(function () {
	$('.profile_div').toggle();
	$('.widget').toggle();
	$("#chats").html("");
});


// ------------------------------------------ Suggestions -----------------------------------------------

function addSuggestion(textToAdd) {
	setTimeout(function () {
		var suggestions = textToAdd;
		var suggLength = textToAdd.length;
		$(' <div class="singleCard"> <div class="suggestions"><div class="menu"></div></div></diV>').appendTo('.chats').hide().fadeIn(1000);
		// Loop through suggestions
		for (i = 0; i < suggLength; i++) {
			$('<div class="menuChips" data-payload=\''+(suggestions[i].payload)+'\'>' + suggestions[i].title + "</div>").appendTo(".menu");
		}
		scrollToBottomOfResults();
	}, 1000);
	
	$(".usrInput").attr("disabled",true);
}


// on click of suggestions, get the value and send to rasa
$(document).on("click", ".menu .menuChips", function () {
	var text = this.innerText;
	var payload= this.getAttribute('data-payload');
	console.log("button payload: ",this.getAttribute('data-payload'))
	setUserResponse(text);
	send(text,payload);
	$('.suggestions').remove(); //delete the suggestions 
});







function send1(message) {
	console.log("User Message:", message)
	$.ajax({
		url: 'http://localhost:5005/webhooks/rest/webhook',
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify({
			"message": message,
			"sender": "Me"
		}),
		success: function (data, textStatus) {
			if(data != null){
					setBotResponse(data);
			}
			console.log("Rasa Response: ", data, "\n Status:", textStatus)
		},
		error: function (errorMessage) {
			setBotResponse("");
			console.log('Error' + errorMessage);

		}
	});
}


function startChat(){
	$.ajax({
		url: 'api/startChat',
		type: 'GET',
		dataType: 'json',
		success: function (data, textStatus) {
			console.log("Rasa Response: ", data, "\n Status:", textStatus)
			if(data.responseArray != null){
				setBotResponse(data.responseArray);
			}
			
		},
		error: function (errorMessage) {
			setBotResponse("");
			console.log('Error' + errorMessage);

		}
	});
}
