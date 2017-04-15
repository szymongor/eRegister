//
//  JWT.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 15.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import Foundation

class JWT {
    
    static func decode(token: String) -> String {
        let components = token.components(separatedBy: ".")
        var payload = components[1]
        
        if payload.characters.count % 4 != 0 {
            let padlen = 4 - payload.characters.count % 4
            payload += String(repeating: "=", count: padlen)
        }
        
        if let data = Data(base64Encoded: payload, options: []),
            let str = String(data: data, encoding: String.Encoding.utf8) {
            return str
        }
        
        return ""
    }
    
}
