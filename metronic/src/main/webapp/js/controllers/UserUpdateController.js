

MetronicApp.controller('UserUpdateController', ['$scope', '$stateParams','UserService', function($scope, $stateParams,UserService) {
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