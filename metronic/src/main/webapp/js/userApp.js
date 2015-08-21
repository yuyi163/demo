var UserApp = angular.module("UserApp", [
    "ui.router", 
    "ui.bootstrap", 
    "oc.lazyLoad",  
    "ngResource", 
    "ngSanitize",
    "ngCookies"

]); 

/* Configure ocLazyLoader(refer: https://github.com/ocombe/ocLazyLoad) */
UserApp.config(['$ocLazyLoadProvider', function($ocLazyLoadProvider) {
    $ocLazyLoadProvider.config({
        // global configs go here
    });
}]);

UserApp.service('UserService', [ '$resource', function($resource) {
	return $resource(Global.ROOT_PATH + '/rest/user/:id', null, {
		'save' : {
			method : 'POST',
			url : Global.ROOT_PATH + '/rest/user'
		},
		'update' : {
			method : 'PUT'
		},
		'updatePersonal' : {
			method : 'PUT',
			url : Global.ROOT_PATH + '/rest/user/:username/personal'
		},
		'changePassword' : {
			method : 'PUT',
			url : Global.ROOT_PATH + '/rest/user/:username/password'
		},
		'enable' : {
			method : 'PUT',
			url : Global.ROOT_PATH + '/rest/user/enable'
		},
		'disable' : {
			method : 'PUT',
			url : Global.ROOT_PATH + '/rest/user/disable'
		},
		'DELETE' : {
			method : 'DELETE'
		},
		'findAll' : {
			method : 'GET',
			url : Global.ROOT_PATH + '/rest/user',
			isArray : true
		}
	});
} ]);


UserApp.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
    // Redirect any unmatched url
    $urlRouterProvider.otherwise("/signIn.html");  
    
    $stateProvider


    .state('signIn', {
        url: "/signIn.html",
        templateUrl: "views/user/signIn.html"
    })
    
     .state('forgetPwd', {
        url: "/forgetPwd.html",
        templateUrl: "views/user/forgetPwd.html"
    })
    

    .state('signUp', {
        url: "/signUp.html",
        templateUrl: "views/user/signUp.html",            
        data: {pageTitle: 'xxxx'},
        controller: "SignUpController",
        resolve: {
            deps: ['$ocLazyLoad', function($ocLazyLoad) {
                return $ocLazyLoad.load({
                    name: 'UserApp',
                    insertBefore: '#ng_load_plugins_before', // load the above css files before a LINK element with this ID. Dynamic CSS files must be loaded between core and theme css files
                    files: [
                        
                    ] 
                });
            }]
        }
    })


}]);


UserApp.controller('SignUpController', ['$scope', 'UserService', function($scope, UserService) {
    $scope.$on('$viewContentLoaded', function() {
    	});
    	
    $scope.submit = function() {
		//
		
		// submit
		Metronic.blockUI();
		UserService.save(null, $scope.user, function(){
			Metronic.unblockUI();
			Notification.success('注册成功');
		}, function(error){
			Metronic.unblockUI();
			Notification.error(error.data);
		});
	}
}]);
