//
//  SubjectHeaderView.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 16.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

class SubjectHeaderView: UIView {

    @IBOutlet weak var container: UIView! {
        didSet {
            container.backgroundColor = Colors.MAIN
            container.layer.borderColor = Colors.SECOND_APP_COLOR.cgColor
            container.layer.borderWidth = 1.0
            container.layer.cornerRadius = 8.0
        }
    }
    @IBOutlet weak var dateLabel: UILabel! {
        didSet {
            dateLabel.text = "Data"
            dateLabel.textColor = Colors.SECOND_APP_COLOR
        }
    }
    @IBOutlet weak var descriptionLabel: UILabel! {
        didSet {
            descriptionLabel.text = "Opis"
            descriptionLabel.textColor = Colors.SECOND_APP_COLOR
        }
    }
    @IBOutlet weak var gradeLabel: UILabel! {
        didSet {
            gradeLabel.text = "Ocena"
            gradeLabel.textColor = Colors.SECOND_APP_COLOR
        }
    }

}
