Notification = function(toastr) {
	toastr.options = {
		"closeButton" : true,
		"debug" : false,
		"positionClass" : "toast-top-right",
		"onclick" : null,
		"showDuration" : "1000",
		"hideDuration" : "1000",
		"timeOut" : "5000",
		"extendedTimeOut" : "1000",
		"showEasing" : "swing",
		"hideEasing" : "linear",
		"showMethod" : "fadeIn",
		"hideMethod" : "fadeOut"
	};
	return {
		"success" : function(message, title) {
			toastr["success"](message, title || '');
		},
		"error" : function(message, title) {
			toastr["error"](message, title || '');
		}
	};
}(toastr);

Pentahohub = function() {

	var Cache = {
		"put" : function(key, value) {
			sessionStorage.setItem(key, JSON.stringify(value));
		},
		"get" : function(key) {
			var value = sessionStorage.getItem(key);
			if (value) {
				return JSON.parse(value);
			}
			return null;
		},
		"remove" : function(key) {
			sessionStorage.removeItem(key);
		},
		"clear" : function() {
			sessionStorage.clear();
		},
		"each" : function(callback) {
			for ( var key in sessionStorage) {
				callback(key, this.get(key));
			}
		}
	};

	var isMobile = {
		"Android" : function() {
			return navigator.userAgent.match(/Android/i) ? true : false;
		},
		"BlackBerry" : function() {
			return navigator.userAgent.match(/BlackBerry/i) ? true : false;
		},
		"iOS" : function() {
			return navigator.userAgent.match(/iPhone|iPad|iPod/i) ? true
					: false;
		},
		"Windows" : function() {
			return (navigator.userAgent.match(/Windows Phone/i) || navigator.userAgent
					.match(/WPDesktop/i)) ? true : false;
		},
		"any" : function() {
			return (isMobile.Android() || isMobile.BlackBerry()
					|| isMobile.iOS() || isMobile.Windows());
		}
	};
	
	var UrlParams = {
		"get" : function(name){
			var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
			var r = window.location.search.substr(1).match(reg);
			if (r!=null) return unescape(r[2]); return null;
		}
	};

	return {
		"isMobile" : isMobile,
		"Cache" : Cache,
		"UrlParams" : UrlParams,
		"Notification" : Notification
	};

}();
