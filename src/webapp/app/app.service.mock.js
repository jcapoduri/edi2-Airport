'use strict';

(function() {

  angular
    .module('Airport.mock')
    .service('BackendService', BackendService);

  BackendService.$inject = [];

  function BackendService() {
    this.data = {
      airline: [
        {
          id: 1,
          code: 'AAR',
          name: 'Aerolineas Argentinas'
        },
        {
          id: 2,
          code: 'LTM',
          name: 'LATAM'
        }
      ],
      destiny: [
        {
          id: 1,
          code: 'BHI',
          name: 'Bahia Blanca'
        },
        {
          id: 2,
          code: 'BAI',
          name: 'Buenos Aires'
        }
      ],
      flight: [],
      passenger: [],
      flightroute: []
    };

    this.getData = function(entity) {
        return this.data[entity];
    };

    this.setData = function(data) {
        this.data = data;
    };

    this.findOne = function(entity, entityid) {
        // find the game that matches that id
        var entityData = this.getData(entity);
        var list = $.grep(entityData, function(element, index) {
            return (element.id == entityid);
        });
        if(list.length === 0) {
            return {};
        }
        // even if list contains multiple items, just return first one
        return list[0];
    };

    this.findAll = function(entity) {
        return this.getData(entity);
    };

    // options parameter is an object with key value pairs
    // in this simple implementation, value is limited to a single value (no arrays)
    this.findMany = function(options) {
        // find games that match all of the options
        var list = $.grep(this.getData(), function(element, index) {
            var matchAll = true;
            $.each(options, function(optionKey, optionValue) {
                if(element[optionKey] !== optionValue) {
                    matchAll = false;
                    return false;
                }
            });
            return matchAll;
        });
    };

    // add a new data item that does not exist already
    // must compute a new unique id and backfill in
    this.addOne = function(entity, dataItem) {
        // must calculate a unique ID to add the new data
        var newId = this.newId(entity);
        dataItem.id = newId;
        this.data[entity].push(dataItem);
        return dataItem;
    };

    // return an id to insert a new data item at
    this.newId = function(entity) {
        // find all current ids
        var currentIds = $.map(this.getData(entity), function(dataItem) { return dataItem.id; });
        // since id is numeric, and we will treat like an autoincrement field, find max
        var maxId = Math.max.apply(Math, currentIds);
        // increment by one
        return isNaN(maxId) ? 1 : maxId + 1;
    };

    this.updateOne = function(entity, entityid, dataItem) {
        // find the game that matches that id
        var data = this.getData(entity);
        var match = null;
        for (var i=0; i < data.length; i++) {
            if(data[i].id === entityid) {
                match = data[i];
                break;
            }
        }
        if(!angular.isObject(match)) {
            return {};
        }
        angular.extend(match, dataItem);
        return match;
    };

    this.deleteOne = function(entity, entityId) {
        // find the game that matches that id
        var data = this.getData(entity);
        var match = false;
        for (var i=0; i < data.length; i++) {
            if(data[i].id === entityId) {
                match = true;
                data.splice(i, 1);
                break;
            }
        }
        return match;
    };
  };

})();
