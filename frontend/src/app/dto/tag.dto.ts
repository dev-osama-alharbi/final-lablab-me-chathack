
export class ComponentDTO{
  private _id: number = 0;
  private _msgId: number = 0;
  private _projectId: number = 0;
  private _msg: string = '';
  private _componentType: string = '';
  private _title: string = '';

  get title(): string {
    return this._title;
  }

  set title(value: string) {
    this._title = value;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get msgId(): number {
    return this._msgId;
  }

  set msgId(value: number) {
    this._msgId = value;
  }

  get projectId(): number {
    return this._projectId;
  }

  set projectId(value: number) {
    this._projectId = value;
  }

  get msg(): string {
    return this._msg;
  }

  set msg(value: string) {
    this._msg = value;
  }

  get componentType(): string {
    return this._componentType;
  }

  set componentType(value: string) {
    this._componentType = value;
  }
}
export class ComponentM {
  private _id: number = 0;
  private _msgId: number = 0;
  private _projectId: number = 0;
  private _msg: string = '';
  private _componentType: string = '';
  private _items: Item[] = [];
  private _title: string = '';


  get title(): string {
    return this._title;
  }

  set title(value: string) {
    this._title = value;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get msgId(): number {
    return this._msgId;
  }

  set msgId(value: number) {
    this._msgId = value;
  }

  get projectId(): number {
    return this._projectId;
  }

  set projectId(value: number) {
    this._projectId = value;
  }

  get msg(): string {
    return this._msg;
  }

  set msg(value: string) {
    this._msg = value;
  }

  get componentType(): string {
    return this._componentType;
  }

  set componentType(value: string) {
    this._componentType = value;
  }

  get items(): Item[] {
    return this._items;
  }

  set items(value: Item[]) {
    this._items = value;
  }
}
export class Tag {
  private _isComponent: boolean = false;
  private _msgId: number = 0;
  private _item: Item | undefined;
  private _component: ComponentM | undefined;
  private _title: string = '';

  get title(): string {
    return this._title;
  }

  set title(value: string) {
    this._title = value;
  }

  get isComponent(): boolean {
    return this._isComponent;
  }

  set isComponent(value: boolean) {
    this._isComponent = value;
  }

  get msgId(): number {
    return this._msgId;
  }

  set msgId(value: number) {
    this._msgId = value;
  }

  get item(): Item | undefined {
    return this._item;
  }

  set item(value: Item | undefined) {
    this._item = value;
  }

  get component(): ComponentM | undefined {
    return this._component;
  }

  set component(value: ComponentM | undefined) {
    this._component = value;
  }
}

export class Item{
  private _id: number = 0;
  private _componentId: number = 0;
  private _msgId: number = 0;
  private _msg: string = '';
  private _projectId: number = 0;

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get componentId(): number {
    return this._componentId;
  }

  set componentId(value: number) {
    this._componentId = value;
  }

  get msgId(): number {
    return this._msgId;
  }

  set msgId(value: number) {
    this._msgId = value;
  }

  get msg(): string {
    return this._msg;
  }

  set msg(value: string) {
    this._msg = value;
  }

  get projectId(): number {
    return this._projectId;
  }

  set projectId(value: number) {
    this._projectId = value;
  }
}
