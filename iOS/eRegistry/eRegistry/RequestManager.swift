//
//  RequestManager.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 10.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import Foundation
import Alamofire

class RequestManager {
    
    typealias JSONStandard = Dictionary<String, AnyObject>
    
    fileprivate static func getWSAddress() -> String {
        let address = "http://localhost:8080/auth"
        return address
    }
    
    typealias LoginCompletion = (Bool)->()
    
    static func login(username: String, password: String, completion: @escaping LoginCompletion) {
        let url: URL = URL(string: getWSAddress())!
        let parameters: [String : AnyObject] =
            [
                "login": username as AnyObject,
                "password": password as AnyObject
            ]
        Alamofire.request(url, method: .post, parameters: parameters, encoding: JSONEncoding.default).validate().responseJSON(completionHandler: {
            response in
            
            var success = false
            let result = response.result
            
            if result.isSuccess {
                if let json = result.value as? JSONStandard,
                    let token = json["token"] as? String {
                    print(json)
                    UserDefaultValues.username = username
                    UserDefaultValues.password = password
                    UserDefaultValues.token = token
                    print(UserDefaultValues.token)
                    success = true
                }
            }
            completion(success)
        })

    }
    
}


