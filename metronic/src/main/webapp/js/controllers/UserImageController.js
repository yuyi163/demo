

MetronicApp.controller('UserImageController', ['$scope', '$rootScope', 'UserService',function($scope, $rootScope,UserService) {
    $scope.$on('$viewContentLoaded', function() {
    	console.log(11111111111111111111111);
    	$scope.uploadPoster = function(data){
    		$scope.image = {};
			$scope.image.poster = data.path;
			$scope.image.posterURI = data.uri;
		};
		
		UserService.get({
        	id : $rootScope.principal.id
        }, function(data){
        	$scope.user = data;
        	$scope.user.image = $scope.image.poster;
        });
		
		$scope.submit = function() {
		
			Metronic.blockUI();
			UserService.updateImage({
				id : $rootScope.principal.id
			}, $scope.user, function(){
				Metronic.unblockUI();
				Notification.success('图片已更新');
			}, function(error){
				Metronic.unblockUI();
				Notification.error(error.data);
			});
		}
    	
    	});
    	
   
}]);