var userApp = angular.module("userApp", [
    "ui.router", 
    "ui.bootstrap", 
    "oc.lazyLoad",  
    "ngResource", 
    "ngSanitize"
]); 

signupApp.service('UserService', [ '$resource', function($resource) {
	return $resource(Global.ROOT_PATH + '/rest/users/:id', null, {
		'save' : {
			method : 'POST',
			url : Global.ROOT_PATH + '/rest/user'
		},
		'update' : {
			method : 'PUT'
		},
		'updatePersonal' : {
			method : 'PUT',
			url : Global.ROOT_PATH + '/rest/users/:username/personal'
		},
		'changePassword' : {
			method : 'PUT',
			url : Global.ROOT_PATH + '/rest/users/:username/password'
		},
		'enable' : {
			method : 'PUT',
			url : Global.ROOT_PATH + '/rest/users/enable'
		},
		'disable' : {
			method : 'PUT',
			url : Global.ROOT_PATH + '/rest/users/disable'
		},
		'DELETE' : {
			method : 'DELETE'
		},
		'findAll' : {
			method : 'GET',
			url : Global.ROOT_PATH + '/rest/users',
			isArray : true
		}
	});
} ]);

signupApp.controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
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

