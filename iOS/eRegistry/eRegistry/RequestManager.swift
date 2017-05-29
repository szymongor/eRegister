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
        let urlString = getWSAddress() + Endpoints.auth
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
                    print(payloadStr)
                    if let payload = JSON.convertToJSON(text: payloadStr),
                         let roles = payload["roles"] as? String,
                        let id = payload["id"] as? String {
                        User.instance.roleName = roles
                        guard let idInt = Int(id) else { return }
                        User.instance.id = idInt
                    }
                    success = true
                }
            }
            completion(success)
        })

    }
    
    typealias LessonsCompletion = (Bool, [Subject])->()
    
    static func getAllLessons(completion: @escaping LessonsCompletion) {
        let urlString = getWSAddress() + Endpoints.lessons
        let url: URL = URL(string: urlString)!
        let header: HTTPHeaders = ["Authorization" : User.instance.token]
        
        Alamofire.request(url, method: .get, parameters: nil, encoding: JSONEncoding.default, headers: header).validate().responseJSON(completionHandler: {
            response in
            
            var success = false
            let result = response.result
            
            var subjects: [Subject] = []
            
            if result.isSuccess {
                if let json = result.value as? JSONStandard {
                    if let lessons = json["lessons"] as? [JSONStandard] {
                        print(lessons)
                        for lesson in lessons {
                            let subject = Subject(usingJson: lesson)
                            subjects.append(subject)
                        }
                        success = true
                    }
                }
            }
            completion(success, subjects)
            
        })
    }
    
    typealias NewPasswordCompletion = (Bool)->()
    
    static func changePassword(oldPassword: String, newPassword: String, completion: @escaping NewPasswordCompletion) {
        let urlString = getWSAddress() + Endpoints.newPassword
        let url = URL(string: urlString)!
        let header: HTTPHeaders = ["Authorization" : User.instance.token]
        
        let parameters: [String : AnyObject] = [
            "newPassword": newPassword as AnyObject,
            "oldPassword": oldPassword as AnyObject
        ]
        
        Alamofire.request(url, method: .post, parameters: parameters, encoding: JSONEncoding.default, headers: header).validate().responseJSON(completionHandler: {
            response in
            
            var success = false
            let result = response.result
            if let json = result.value as? JSONStandard {
                print(json)
            }
            if result.isSuccess {
                if let json = result.value as? [JSONStandard] {
                    print(json)
                }
                success = true
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


