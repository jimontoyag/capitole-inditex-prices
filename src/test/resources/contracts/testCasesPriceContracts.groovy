import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            name 'Test 1'
            request {
                method 'GET'
                urlPath(
                        '/prices/final-price'
                ) {
                    queryParameters {
                        parameter 'date': '2020-06-14T10:00:00Z'
                        parameter 'product': 35455
                        parameter 'brand': 1
                    }
                }
                headers {
                    contentType('application/json')
                }
            }
            response {
                status OK()
                body([
                        product_id: 35455,
                        brand_id  : 1,
                        price_id  : 1,
                        from_date : '2020-06-14T00:00:00Z',
                        to_date   : '2020-12-31T23:59:59Z',
                        price     : 35.50,
                        currency  : 'EUR'
                ])
                headers {
                    contentType('application/json')
                }
            }
        },
        Contract.make {
            name 'Test 2'
            request {
                method'GET'
                urlPath(
                        '/prices/final-price'
                ) {
                    queryParameters {
                        parameter 'date': '2020-06-14T16:00:00Z'
                        parameter 'product': 35455
                        parameter 'brand': 1
                    }
                }
                headers {
                    contentType('application/json')
                }
            }
            response {
                status OK()
                body([
                        product_id: 35455,
                        brand_id  : 1,
                        price_id  : 2,
                        from_date : '2020-06-14T15:00:00Z',
                        to_date   : '2020-06-14T18:30:00Z',
                        price     : 25.45,
                        currency  : 'EUR'
                ])
                headers {
                    contentType('application/json')
                }
            }
        },
        Contract.make {
            name 'Test 3'
            request {
                method'GET'
                urlPath(
                        '/prices/final-price'
                ) {
                    queryParameters {
                        parameter 'date': '2020-06-14T21:00:00Z'
                        parameter 'product': 35455
                        parameter 'brand': 1
                    }
                }
                headers {
                    contentType('application/json')
                }
            }
            response {
                status OK()
                body([
                        product_id: 35455,
                        brand_id  : 1,
                        price_id  : 1,
                        from_date : '2020-06-14T00:00:00Z',
                        to_date   : '2020-12-31T23:59:59Z',
                        price     : 35.50,
                        currency  : 'EUR'
                ])
                headers {
                    contentType('application/json')
                }
            }
        },
        Contract.make {
            name 'Test 4'
            request {
                method'GET'
                urlPath(
                        '/prices/final-price'
                ) {
                    queryParameters {
                        parameter 'date': '2020-06-15T10:00:00Z'
                        parameter 'product': 35455
                        parameter 'brand': 1
                    }
                }
                headers {
                    contentType('application/json')
                }
            }
            response {
                status OK()
                body([
                        product_id: 35455,
                        brand_id  : 1,
                        price_id  : 3,
                        from_date : '2020-06-15T00:00:00Z',
                        to_date   : '2020-06-15T11:00:00Z',
                        price     : 30.50,
                        currency  : 'EUR'
                ])
                headers {
                    contentType('application/json')
                }
            }
        },
        Contract.make {
            name 'Test 5'
            request {
                method'GET'
                urlPath(
                        '/prices/final-price'
                ) {
                    queryParameters {
                        parameter 'date': '2020-06-16T21:00:00Z'
                        parameter 'product': 35455
                        parameter 'brand': 1
                    }
                }
                headers {
                    contentType('application/json')
                }
            }
            response {
                status OK()
                body([
                        product_id: 35455,
                        brand_id  : 1,
                        price_id  : 4,
                        from_date : '2020-06-15T16:00:00Z',
                        to_date   : '2020-12-31T23:59:59Z',
                        price     : 38.95,
                        currency  : 'EUR'
                ])
                headers {
                    contentType('application/json')
                }
            }
        }
]
