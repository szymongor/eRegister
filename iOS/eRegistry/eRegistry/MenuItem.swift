//
//  MenuItem.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 11.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

protocol MenuItemDelegate {
    func onMenuItemClick(sender: MenuItem)
}

class MenuItem: UIView {

    @IBOutlet weak var imageView: UIImageView! {
        didSet {
            imageView.image = #imageLiteral(resourceName: "logoIcon")
        }
    }
    @IBOutlet weak var bottomView: UIView! {
        didSet {
            bottomView.backgroundColor = UIColor.clear
        }
    }

    @IBOutlet weak var descriptionLabel: UILabel!
    
    var delegate: MenuItemDelegate?
    
    var contentView : UIView?
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        xibSetup()
    }
    
    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        xibSetup()
    }
    
    func xibSetup() {
        contentView = loadViewFromNib()
        contentView!.frame = bounds
        // Make the view stretch with containing view:
        contentView!.autoresizingMask = [UIViewAutoresizing.flexibleWidth, UIViewAutoresizing.flexibleHeight]
        addSubview(contentView!)
        setGesture()
        self.contentView?.layer.borderWidth = 1.0
        self.contentView?.layer.borderColor = UIColor.black.cgColor
    }
    
    func loadViewFromNib() -> UIView! {
        return UINib(nibName: "MenuItem", bundle: nil).instantiate(withOwner: self, options: nil).first as! UIView
    }
    
    func setGesture() {
        let tapGesture = UITapGestureRecognizer(target: self, action: #selector(onClick))
        self.addGestureRecognizer(tapGesture)
        self.isUserInteractionEnabled = true
    }
    
    func setModel(_ model: MenuItemModel) {
        imageView.image = model.image
        descriptionLabel.text = model.description
    }
    
    func onClick() {
        delegate?.onMenuItemClick(sender: self)
        RequestManager.getUsers()
    }
    
}
