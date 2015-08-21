var userApp = angular.module("userApp", [
    "ui.router", 
    "ui.bootstrap", 
    "oc.lazyLoad",  
    "ngResource", 
    "ngSanitize"
]); 

userApp.service('UserService', [ '$resource', function($resource) {
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

userApp.controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
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

userApp.controller('UserUpdateController', ['$scope', '$stateParams','UserService', function($scope, $stateParams,UserService) {
    $scope.$on('$viewContentLoaded', function() {
    	
    	UsersService.get({
        	id : $stateParams.id
        }, function(data){
        	$scope.user = data;
        });

		$scope.submit = function() {
			//
			//if (!$scope.form.$valid) {
			//	return;
			//}
			
			// submit
			Metronic.blockUI();
			UsersService.update({
				id : $stateParams.id
			}, $scope.user
			, function(){
				Metronic.unblockUI();
				Notification.success('用户已更新');
			}, function(error){
				Metronic.unblockUI();
				Notification.error(error.data);
			});
		}
    	
    	});
    	
   
}]);

