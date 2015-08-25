

MetronicApp.controller('UserController', ['$scope', '$rootScope','UserService', function($scope, $rootScope,UserService) {
    $scope.$on('$viewContentLoaded', function() {
    	
    	$scope.uploadPoster = function(data){
    		$scope.image = {};
			$scope.image.poster = data.path;
			$scope.image.posterURI = data.uri;
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
		}
    	
    	});
    	
   
}]);