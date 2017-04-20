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
        let address = "http://157.158.16.186:8090/"
        return address
    }
    
    typealias LoginCompletion = (Bool)->()
    
    static func login(username: String, password: String, completion: @escaping LoginCompletion) {
        let urlString = getWSAddress()+"auth"
        let url: URL = URL(string: urlString)!
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
                    User.instance.username = username
                    User.instance.password = password
                    User.instance.token = token
                    
                    let payloadStr = JWT.decode(token: token)
                    if let payload = JSON.convertToJSON(text: payloadStr),
                         let role = payload["role"] as? String {
                        User.instance.roleName = role
                    }
                    success = true
                }
            }
            completion(success)
        })

    }
    
    static func getUsers() {
        
        let urlString = getWSAddress()+"EregUsers"
        let url: URL = URL(string: urlString)!
        
        let header: HTTPHeaders = ["Authorization" : User.instance.token]
        
        Alamofire.request(url, method: .get, parameters: nil, encoding: JSONEncoding.default, headers: header).validate().responseJSON(completionHandler: {
            response in
            
            var success = false
            let result = response.result
            
            if result.isSuccess {
                if let json = result.value as? [JSONStandard] {
                    print(json)
                }
            }
        })
    }
    
}


