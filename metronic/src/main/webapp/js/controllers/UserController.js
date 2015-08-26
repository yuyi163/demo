

MetronicApp.controller('UserController', ['$scope', '$rootScope','UserService', function($scope, $rootScope,UserService) {
    $scope.$on('$viewContentLoaded', function() {
    	
    	$scope.uploadPoster = function(data){
    		//$scope.image = {};
			//$scope.image.poster = data.path;
			//$scope.image.posterURI = data.uri;
    		$rootScope.principal.image = data.uri;
		};
		
    	UserService.get({
        	id : $rootScope.principal.id
        }, function(data){
        	$scope.user = data;
        });

		$scope.savePersonalInfo = function() {
			
			Metronic.blockUI();
			UserService.update({
				id : $rootScope.principal.id
			}, {
				mobilePhone:$scope.user.mobilePhone,
				email:$scope.user.email
			}, function(){
				Metronic.unblockUI();
				Notification.success('用户已更新');
			}, function(error){
				Metronic.unblockUI();
				Notification.error(error.data);
			});
		};
    	
    
	    $scope.updateImage = function() {
			Metronic.blockUI();
			UserService.updateImage({
				id : $rootScope.principal.id
			}, {
				image:$rootScope.principal.image
			}, function(){
				Metronic.unblockUI();
				Notification.success('头像已更新');
			}, function(error){
				Metronic.unblockUI();
				Notification.error(error.data);
			});
		};
		
		 $scope.updatePwd = function() {
			// validate
				if (!$scope.change_password_form.$valid) {
					return;
				}
				if ($scope.passwordChange.newPassword1 != $scope.passwordChange.newPassword2) {
					Notification.success('两次输入密码不一致');
					return;
				}
				// submit
				Metronic.blockUI();
				UserService.updatePwd({
					username : $rootScope.principal.username
				}, {
					oldPassword : $scope.passwordChange.oldPassword,
					newPassword : $scope.passwordChange.newPassword1
				},
				function(){
					Metronic.unblockUI();
					Notification.success('密码已更新');
				}, function(error){
					Metronic.unblockUI();
					Notification.error(error.data);
				});
			};
		
	});
    	
   
}]);