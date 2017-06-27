//
//  EducatorTVCell.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 17.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit


enum EducatorDataType {
    case surname
    case name
    case phone
    case email
}

class EducatorTVCell: UITableViewCell {

    @IBOutlet weak var container: UIView! {
        didSet {
            container.appTheme()
            
            let tapGesture = UITapGestureRecognizer(target: self, action: #selector(onDataTap))
            container.addGestureRecognizer(tapGesture)
            container.isUserInteractionEnabled = true
        }
    }
    @IBOutlet weak var titleLabel: UILabel! {
        didSet {
            titleLabel.textColor = Colors.MAIN
        }
    }
    @IBOutlet weak var descriptionLabel: UILabel! {
        didSet {
            descriptionLabel.textColor = Colors.MAIN
        }
    }

    var type: EducatorDataType = .name
    
    var contactData: String = ""
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    func setView(type: EducatorDataType, description: String?) {
        self.type = type
        switch type {
        case .surname:
            titleLabel.text = "Nazwisko"
        case .name:
            titleLabel.text = "Imię"
        case .phone:
            titleLabel.text = "Telefon"
        case .email:
            titleLabel.text = "E-mail"
        }
        guard let desc = description else {
            return
        }
        contactData = desc.replacingOccurrences(of: " ", with: "")
        descriptionLabel.text = contactData
    }
    
}

// MARK: - Cell Tap

extension EducatorTVCell {
    
    func onDataTap() {
        var prefix = ""
        switch type {
        case .phone:
            prefix = "telprompt://"
        case .email:
            prefix = "mailto:"
        default:
            return
        }
        let urlOptional = URL(string: prefix+"\(contactData)")
        if let url = urlOptional {
            UIApplication.shared.openURL(url)
        }
    }
    
}
