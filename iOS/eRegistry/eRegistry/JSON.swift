//
//  JSON.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 15.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import Foundation

typealias JSONStandard = Dictionary<String, AnyObject>

class JSON {
    
    static func convertToJSON(text: String) -> JSONStandard? {
        if let data = text.data(using: .utf8) {
            do {
                return try JSONSerialization.jsonObject(with: data, options: []) as? [String: Any] as JSONStandard?
            } catch {
                print(error.localizedDescription)
            }
        }
        return nil
    }

    
}
